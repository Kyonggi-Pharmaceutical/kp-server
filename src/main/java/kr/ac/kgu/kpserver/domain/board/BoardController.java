package kr.ac.kgu.kpserver.domain.board;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import kr.ac.kgu.kpserver.domain.board.Articles.dto.ArticleDto;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "게시글 카테고리 분류 API")
@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @Operation(summary = "카테고리별 모아보기 API")
    @UserAuthenticated
    @GetMapping("/{boardId}/articles")
    public ResponseEntity<List<ArticleDto>> getArticlesByCategory(@RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "10") int size,
                                                                  @PathVariable Long boardId) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Article> articlePage = boardService.getArticlesByBoardId(boardId, pageable);
        List<ArticleDto> articleDtos = articlePage.getContent().stream()
                .map(ArticleDto::of)
                .collect(Collectors.toList());
        return ResponseEntity.ok(articleDtos);
    }
}
