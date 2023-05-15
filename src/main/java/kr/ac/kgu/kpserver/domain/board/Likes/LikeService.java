package kr.ac.kgu.kpserver.domain.board.Likes;

import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import kr.ac.kgu.kpserver.domain.board.Articles.ArticleRepository;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;

    @Transactional
    public boolean checkedLikes(Long userId, Long articleId) throws AccessDeniedException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not found user id : " + userId));

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not found article id : " + articleId));

        if (likeRepository.findByUserAndArticle(user, article).isPresent()) {
            throw new AccessDeniedException("User already liked the article.");
        }

        Like like = new Like(article, user);
        likeRepository.save(like);
        userRepository.save(user);
        articleRepository.save(article);
        return true;
    }

    @Transactional
    public boolean deletedLikes(Long userId, Long articleId, Long likeId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not found user id : " + userId));
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not found article id : " + articleId));
        Like like = likeRepository.findById(likeId)
                .orElseThrow(() -> new NotFoundException("Could not find like with id: " + likeId));

        if (user.getId().equals(article.getUser().getId())) {
            likeRepository.delete(like);

        }
        return false;
    }

    @Transactional
    public List<Article> getLikedArticlesForUser(Long userId) throws NotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));

        return articleRepository.findByLikesUser(user);
    }

}
