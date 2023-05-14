package kr.ac.kgu.kpserver.domain.board.Articles;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.Articles.dto.ArticleDto;
import kr.ac.kgu.kpserver.domain.board.Comments.Comment;
import kr.ac.kgu.kpserver.domain.board.Comments.CommentService;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@Tag(name = "게시글 API")
@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final CommentService commentService;

    @Operation(summary = "게시글 저장 작성 API")
    @UserAuthenticated
    @PostMapping("{boardId}/createdAndUpdatedArticle")
    public ResponseEntity<Void> createdArticles(User user,
                                                @PathVariable Long boardId,
                                                @RequestBody ArticleDto articleDto) {
        articleService.createdAndUpdatedArticle(user.getId(), boardId, articleDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "게시글 수정 작성 API")
    @UserAuthenticated
    @PutMapping("/{articleId}")
    public ResponseEntity<ArticleDto> updatedArticles(User user,
                                                      @PathVariable Long articleId,
                                                      @RequestBody ArticleDto articleDto) {
        articleService.updatedArticle(user.getId(), articleId, articleDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "게시글 삭제 API")
    @UserAuthenticated
    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "게시글 상세 내용 API")
    @UserAuthenticated
    @GetMapping("displayArticles/{articleId}")
    public ResponseEntity<ArticleDto> displayArticleDetails(@PathVariable Long articleId) {
        ArticleDto articleDto = articleService.displayArticleDetails(articleId);
        return ResponseEntity.ok(articleDto);
    }

    @Operation(summary = "각 게시글 좋아요 모아보기 API")
    @UserAuthenticated
    @GetMapping("/{articleId}")
    public ResponseEntity<Integer> getLikesForArticle(@PathVariable Long articleId) throws NotFoundException {
        int likesCount = articleService.getLikesForArticle(articleId);
        return ResponseEntity.ok().body(likesCount);
    }

    @Operation(summary = "게시물 댓글 모아보기 API")
    @UserAuthenticated
    @GetMapping("/{articleId}/comments")
    public ResponseEntity<List<Comment>> getCommentsForArticle(@PathVariable Long articleId) throws NotFoundException {
        List<Comment> comments = commentService.getCommentsForArticle( articleId);
        return ResponseEntity.ok(comments);
    }
}
