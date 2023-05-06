package kr.ac.kgu.kpserver.domain.board.Articles;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.Articles.dto.ArticleDto;
import kr.ac.kgu.kpserver.domain.board.Articles.dto.CreateArticleRequest;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Tag(name = "게시글 API")
@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    @Operation(summary = "게시글 작성 API")
    @UserAuthenticated
    @PostMapping("/postCreated")
    public ResponseEntity<ArticleDto> postBoard(@RequestBody CreateArticleRequest createArticleRequest,
                                                Article article) {
        Article savedBoard = articleService.updateArticle(article, createArticleRequest);
        return ResponseEntity.ok(ArticleDto.from(savedBoard));
    }

    @Operation(summary = "게시글 수정 API")
    @UserAuthenticated
    @PutMapping("/updateArticle")
    public ResponseEntity<ArticleDto> putBoard(Article article,
                                               @Valid @RequestBody CreateArticleRequest createArticleRequest) {

        Article savedBoard = articleService.updateArticle(article, createArticleRequest);
        return ResponseEntity.ok(ArticleDto.from(savedBoard));
    }

    @Operation(summary = "게시글 삭제 API")
    @UserAuthenticated
    @DeleteMapping("/deleteArticle")
    public ResponseEntity<Void> deleteArticle(Article article) {
        articleService.deleteArticle(article);
        return ResponseEntity.ok().build();
    }
}
