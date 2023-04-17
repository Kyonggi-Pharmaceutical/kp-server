package kr.ac.kgu.kpserver.domain.board;

import kr.ac.kgu.kpserver.domain.board.dto.CreateArticleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final ArticleRepository articleRepository;

    public Page<Article> getArticlesByCategory(BoardCategory category, Pageable pageable) {
        return articleRepository.findByBoard(category, pageable);
    }

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

}


