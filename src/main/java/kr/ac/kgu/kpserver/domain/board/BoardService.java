package kr.ac.kgu.kpserver.domain.board;

import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import kr.ac.kgu.kpserver.domain.board.Articles.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final ArticleRepository articleRepository;

    public Page<Article> getArticlesByCategory(BoardCategory category, Pageable pageable) {
        return articleRepository.findByBoard(category, pageable);
    }
}


