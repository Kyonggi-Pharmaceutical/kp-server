package kr.ac.kgu.kpserver.domain.board.Articles;

import kr.ac.kgu.kpserver.domain.board.Articles.dto.ArticleDto;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createdAndUpdatedArticle(Long userId, ArticleDto articleDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + userId));
        Article article =
                new Article(articleDto.getTitle(),
                        articleDto.getDescription(), user);
        articleRepository.save(article);
    }

    @Transactional
    public void updatedArticle(Long userId,
                                 Long articleId,
                                 ArticleDto articleDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + userId));
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + articleId));

        if (!user.getId().equals(article.getUser().getId())) {
            return;
        }
        article.setTitle(articleDto.getTitle());
        article.setDescription(articleDto.getDescription());
        articleRepository.save(article);
    }

    @Transactional(readOnly = true)
    public ArticleDto displayArticleDetails(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + articleId));
        return ArticleDto.of(article);
    }

    @Transactional
    public void deleteArticle(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + articleId));
        articleRepository.delete(article);
    }

    @Transactional
    public int getLikesForArticle(Long articleId) throws NotFoundException {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + articleId));
        return article.getLikes().size();
    }

}
