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
    public Comment createComment(CommentRequest commentRequest) throws NotFoundException {
        User user = userRepository.findById(commentRequest.getUserId())
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + commentRequest.getUserId()));

        Article article = articleRepository.findById(commentRequest.getArticleId())
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + commentRequest.getArticleId()));

        Comment comment = new Comment(user, article, commentRequest.getDescription());
        commentRepository.save(comment);
        articleRepository.save(article);

        return comment;
    }

    @Transactional
    public Comment updateComment(Long commentId, CommentRequest commentRequest) throws NotFoundException {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Could not find comment with id : " + commentId));

        comment.setDescription(commentRequest.getDescription());
        return commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(CommentRequest commentRequest) throws NotFoundException {
        User user = userRepository.findById(commentRequest.getUserId())
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + commentRequest.getUserId()));

        Article article = articleRepository.findById(commentRequest.getArticleId())
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + commentRequest.getArticleId()));

        Comment comment = commentRepository.findByUserAndArticle(user, article)
                .orElseThrow(() -> new NotFoundException("Could not find comment"));

        commentRepository.delete(comment);
        articleRepository.save(article);
    }

    @Transactional(readOnly = true)
    public List<Comment> getCommentsForArticle(Long articleId) throws NotFoundException {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + articleId));
        return commentRepository.findByArticle(article);
    }

    public List<Comment> getCommentsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + userId));
        return commentRepository.findByUser(user);
    }

}
