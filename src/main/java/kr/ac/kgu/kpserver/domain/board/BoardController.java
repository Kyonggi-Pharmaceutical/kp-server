package kr.ac.kgu.kpserver.domain.board;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import kr.ac.kgu.kpserver.domain.board.Articles.dto.ArticleDto;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "게시글 카테고리 분류 API")
@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @Operation(summary = "스트레스 게시글 모아보기 API")
    @UserAuthenticated
    @GetMapping("/stress")
    public ResponseEntity<Page<ArticleDto>> getStress(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        Page<Article> stressCategory = boardService.getArticlesByCategory(BoardCategory.STRESS, PageRequest.of(page, size));
        Page<ArticleDto> stressCategoryDto = stressCategory.map(ArticleDto::from);
        return ResponseEntity.ok(stressCategoryDto);
    }

    @Operation(summary = "운동 게시글 모아보기 API")
    @UserAuthenticated
    @GetMapping("/exercise")
    public ResponseEntity<Page<ArticleDto>> getExercise(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        Page<Article> exerciseCategory = boardService.getArticlesByCategory(BoardCategory.WEIGHT, PageRequest.of(page, size));
        Page<ArticleDto> exerciseCategoryDto = exerciseCategory.map(ArticleDto::from);
        return ResponseEntity.ok(exerciseCategoryDto);
    }
}