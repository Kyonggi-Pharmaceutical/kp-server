package kr.ac.kgu.kpserver.domain.board;

import kr.ac.kgu.kpserver.domain.board.dto.CommentRequest;
import kr.ac.kgu.kpserver.domain.board.dto.CreateArticleRequest;
import kr.ac.kgu.kpserver.domain.board.dto.LikeRequest;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;

    /*
     *카테고리
     */
    public Page<Article> getArticlesByCategory(BoardCategory category, Pageable pageable) {
        return articleRepository.findByBoard(category, pageable);
    }

    /*
     * 게시글 기능
     */
    @Transactional
    public Article updateArticle(Article article,
                                 CreateArticleRequest createArticleRequest) {
        Article updatedArticle = article.updateArticle(
                createArticleRequest.getTitle(),
                createArticleRequest.getDescription()
        );
        return articleRepository.save(updatedArticle);
    }

    @Transactional
    public void deleteArticle(Article article) {
        articleRepository.delete(article);
    }

    /*
     * 댓글 기능
    */
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

    /*
   좋아요 기능
    */
    @Transactional
    public void checkLikes(LikeRequest likeRequest) throws Exception {
        User user = userRepository.findById(likeRequest.getUserId())
                .orElseThrow(() -> new NotFoundException("Could not found user id : " + likeRequest.getUserId()));

        Article article = articleRepository.findById(likeRequest.getArticleId())
                .orElseThrow(() -> new NotFoundException("Could not found article id : " + likeRequest.getArticleId()));

        if (likeRepository.findByUserAndArticle(user, article).isPresent()) {
            throw new Exception();
        }

        Like like = new Like(article, user);
        likeRepository.save(like);
        articleRepository.save(article);
    }

    @Transactional
    public void deleteLikes(LikeRequest likeRequest) {
        User user = userRepository.findById(likeRequest.getUserId())
                .orElseThrow(() -> new NotFoundException("Could not found user id : " + likeRequest.getUserId()));

        Article article = articleRepository.findById(likeRequest.getArticleId())
                .orElseThrow(() -> new NotFoundException("Could not found article id : " + likeRequest.getArticleId()));

        Like like = likeRepository.findByUserAndArticle(user, article)
                .orElseThrow(() -> new NotFoundException("Could not found like id"));

        likeRepository.delete(like);
        articleRepository.save(article);
    }
    @Transactional
    public int getLikesForArticle(Long articleId) throws NotFoundException {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + articleId));
        return article.getLikes().size();
    }

    @Transactional
    public List<Article> getLikedArticlesForUser(Long userId) throws NotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));

        return articleRepository.findByLikesUser(user);
    }

}


