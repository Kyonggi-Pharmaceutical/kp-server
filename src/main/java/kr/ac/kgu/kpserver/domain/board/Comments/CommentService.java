package kr.ac.kgu.kpserver.domain.board.Comments;

import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import kr.ac.kgu.kpserver.domain.board.Articles.ArticleRepository;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void createdComments(Long userId, Long articleId, CommentRequest commentRequest) throws NotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + userId));

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + articleId));
        boolean canEdit = false;
        Comment comment = new Comment(user, article, commentRequest.getDescription(), canEdit);
        commentRepository.save(comment);
        article.addComments(comment);
        articleRepository.save(article);
    }

    @Transactional
    public void updatedComments(Long userId, Long articleId, Long commentId, CommentRequest commentRequest) throws NotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + userId));
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find comment with id : " + articleId));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Could not find comment with id : " + commentId));

        if (user.getId().equals(article.getUser().getId())) {
            boolean canEdit = true;
            comment.setCanEdit(canEdit);
            comment.setDescription(commentRequest.getDescription());
            commentRepository.save(comment);
        }
    }

    @Transactional
    public void deleteComment(Long userId,
                              Long articleId,
                              Long commentId) throws NotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + userId));

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find comment with id : " + articleId));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Could not find comment with id : " + commentId));
        if (user.getId().equals(article.getUser().getId())) {
            boolean canEdit = true;
            comment.setCanEdit(canEdit);
            commentRepository.delete(comment);
        }

    }

    @Transactional(readOnly = true)
    public List<Comment> getCommentsForArticle(Long articleId) throws NotFoundException {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + articleId));
        return article.getComments();
    }

    public List<Comment> getCommentsByUser(Long userId, Long articleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + userId));

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + articleId));
        return commentRepository.findByUserAndArticle(user, article);
    }

}
