package kr.ac.kgu.kpserver.domain.board.Likes;

import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import kr.ac.kgu.kpserver.domain.board.Articles.ArticleRepository;
import kr.ac.kgu.kpserver.domain.board.Articles.dto.ArticleDto;
import kr.ac.kgu.kpserver.domain.board.Comments.Comment;
import kr.ac.kgu.kpserver.domain.board.Comments.CommentRepository;
import kr.ac.kgu.kpserver.domain.board.Comments.CommentRequest;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final LikeCommentRepository likeCommentRepository;
    private final CommentRepository commentRepository;
    @Transactional
    public void checkedLikeForArticle(Long userId, Long articleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not found user id : " + userId));

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not found article id : " + articleId));

        Like like = new Like(article, user);
        likeRepository.save(like);
        userRepository.save(user);
        articleRepository.save(article);
    }

    @Transactional
    public void addLikeForComment(Long userId, Long commentId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not found user id : " + userId));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Could not found article id : " + commentId));
        CommentRequest.of(comment);
        LikeComment like = new LikeComment(user,  comment);
        likeCommentRepository.save(like);
    }

    @Transactional
    public void deleteLikeForComment(Long userId, Long commentId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not found user id : " + userId));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Could not found article id : " + commentId));
        Optional<LikeComment> like = likeCommentRepository.findByUserAndComment(user, comment);
        like.ifPresent(likeCommentRepository::delete);
    }

    @Transactional
    public void deleteLikes(Long userId, Long articleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user id: " + userId));
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article id: " + articleId));
        Optional<Like> likeOptional = likeRepository.findByUserAndArticle(user, article);
        likeOptional.ifPresent(likeRepository::delete);
    }

    @Transactional
    public List<ArticleDto> getLikedArticleByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));

        List<Like> likes = likeRepository.findByUser(user);
        List<Long> articleIds = likes.stream()
                .map(Like::getArticle)
                .map(Article::getId)
                .collect(Collectors.toList());

        List<Article> articles = articleRepository.findByIdIn(articleIds);

        return articles.stream()
                .map(article -> new ArticleDto(article.getTitle(), article.getDescription()))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CommentRequest> getLikedCommentByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not found user id : " + userId));

        List<LikeComment> likes = likeCommentRepository.findByUser(user);
        List<Long> commentIds = likes.stream()
                .map(LikeComment::getComment)
                .map(Comment::getId)
                .collect(Collectors.toList());

        List<Comment> articles = commentRepository.findByIdIn(commentIds);
        return articles.stream()
                .map(comment -> new CommentRequest(comment.getArticle().getId(), comment.getDescription()))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean maintainLikesForArticle(Long userId, Long articleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + userId));
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article id: " + articleId));
        Optional<Like> like = likeRepository.findByUserAndArticle(user, article);
        return like.isPresent();
    }

    @Transactional
    public boolean maintainLikesForComments(Long userId, Long commentId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + userId));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Could not found article id : " + commentId));
        Optional<LikeComment> like = likeCommentRepository.findByUserAndComment(user, comment);
        return like.isPresent();
    }

    @Transactional
    public int getLikesForArticle(Long articleId) throws NotFoundException {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + articleId));
        List<Like> likes = likeRepository.findAllByArticle(article);
        if (likes.isEmpty()) {
            return 0;
        }
        return likes.stream()
                .map(LikeDto::of)
                .collect(Collectors.toList())
                .size();
    }

    @Transactional
    public int getLikesForComment(Long commentId) throws NotFoundException {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Could not found article id : " + commentId));
        List<LikeComment> likes = likeCommentRepository.findAllByComment(comment);
        if (likes.isEmpty()) {
            return 0;
        }
        return likes.stream()
                .map(LikeCommentDto::of)
                .collect(Collectors.toList())
                .size();
    }
}
