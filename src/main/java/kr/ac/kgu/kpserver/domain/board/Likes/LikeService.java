package kr.ac.kgu.kpserver.domain.board.Likes;

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
public class LikeService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;

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
    public List<Article> getLikedArticlesForUser(Long userId) throws NotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));

        return articleRepository.findByLikesUser(user);
    }

}
