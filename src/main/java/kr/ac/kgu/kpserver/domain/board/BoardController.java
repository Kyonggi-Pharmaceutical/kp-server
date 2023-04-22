package kr.ac.kgu.kpserver.domain.board;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.dto.ArticleDto;
import kr.ac.kgu.kpserver.domain.board.dto.CreateArticleRequest;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Tag(name = "게시글 API")
@RestController
@RequestMapping("/api/v1/community")
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

    @Operation(summary = "게시글 작성 API")
    @UserAuthenticated
    @PostMapping("/postCreated")
    public ResponseEntity<ArticleDto> postBoard(@RequestBody CreateArticleRequest createArticleRequest,
                                                Article article) {
        Article savedBoard = boardService.updateArticle(article, createArticleRequest);
        return ResponseEntity.ok(ArticleDto.from(savedBoard));
    }

    @Operation(summary = "게시글 수정 API")
    @UserAuthenticated
    @PutMapping("/updateArticle")
    public ResponseEntity<ArticleDto> putBoard(Article article,
                                               @Valid @RequestBody CreateArticleRequest createArticleRequest) {

        Article savedBoard = boardService.updateArticle(article, createArticleRequest);
        return ResponseEntity.ok(ArticleDto.from(savedBoard));
    }

    @Operation(summary = "게시글 삭제 API")
    @UserAuthenticated
    @DeleteMapping("/deleteArticle")
    public ResponseEntity<Void> deleteArticle(Article article) {
        boardService.deleteArticle(article);
        return ResponseEntity.ok().build();
    }
}