package kr.ac.kgu.kpserver.domain.board.Articles;

import kr.ac.kgu.kpserver.domain.board.Articles.dto.CreateArticleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

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

    @Transactional
    public int getLikesForArticle(Long articleId) throws NotFoundException {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Could not find article with id : " + articleId));
        return article.getLikes().size();
    }

}
