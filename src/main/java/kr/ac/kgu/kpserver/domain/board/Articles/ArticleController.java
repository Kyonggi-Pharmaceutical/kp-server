package kr.ac.kgu.kpserver.domain.board.Articles;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.Articles.dto.ArticleDto;
import kr.ac.kgu.kpserver.domain.board.Comments.Comment;
import kr.ac.kgu.kpserver.domain.board.Comments.CommentRequest;
import kr.ac.kgu.kpserver.domain.board.Comments.CommentService;
import kr.ac.kgu.kpserver.domain.board.Likes.LikeService;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final LikeService likeService;
    @Operation(summary = "userId API")
    @UserAuthenticated
    @GetMapping("getUserId")
    public ResponseEntity<Long> getUserId(User user) {
        Long userId = articleService.getUserId(user.getId());
        return ResponseEntity.ok(userId);
    }


    @Operation(summary = "게시글 저장 작성 API")
    @UserAuthenticated
    @PostMapping("{boardId}/createdArticle")
    public ResponseEntity<Void> createdArticles(User user,
                                                @PathVariable Long boardId,
                                                @RequestBody ArticleDto articleDto) {
        articleService.createdArticle(user.getId(), boardId, articleDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "게시글 수정 작성 API")
    @UserAuthenticated
    @PutMapping("/{articleId}/{userId}")
    public ResponseEntity<ArticleDto> updatedArticles(@PathVariable Long userId,
                                                      @PathVariable Long articleId,
                                                      @RequestBody ArticleDto articleDto) {
        articleService.updatedArticle(userId, articleId, articleDto);

        return ResponseEntity.ok().build();
    }

    @Operation(summary = "게시글 삭제 API")
    @UserAuthenticated
    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticle(User user, @PathVariable Long articleId) {
        articleService.deleteArticle(user.getId(), articleId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "게시글 상세 내용 API")
    @UserAuthenticated
    @GetMapping("displayArticles/{articleId}")
    public ResponseEntity<ArticleDto> displayArticleDetails(@PathVariable Long articleId) {
        ArticleDto articleDto = articleService.displayArticleDetails(articleId);
        return ResponseEntity.ok(articleDto);
    }
    @Operation(summary = "게시물 모든 댓글 API")
    @UserAuthenticated
    @GetMapping("/{articleId}/comments")
    public ResponseEntity<List<Comment>> getCommentsForArticle(@PathVariable Long articleId) throws NotFoundException {
        List<Comment> comments = commentService.getCommentsForArticle(articleId);
        return ResponseEntity.ok(comments);
    }

    @Operation(summary = "댓글 저장 API")
    @UserAuthenticated
    @PostMapping("/{articleId}/createdComment")
    public ResponseEntity<Void> saveComment(User user,
                                            @PathVariable Long articleId,
                                            @RequestBody CommentRequest commentRequest) {
        commentService.createdComments(user.getId(), articleId, commentRequest);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "댓글 수정 API")
    @UserAuthenticated
    @PutMapping("/{articleId}/updatedComment/{commentId}")
    public ResponseEntity<Void> updateComment(User user,
                                              @PathVariable Long articleId,
                                              @PathVariable Long commentId,
                                              @RequestBody CommentRequest commentRequest) {
        commentService.updatedComments(user.getId(), articleId, commentId, commentRequest);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "댓글 삭제 API")
    @UserAuthenticated
    @DeleteMapping("{articleId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(User user,
                                              @PathVariable Long articleId,
                                              @PathVariable Long commentId) {
        commentService.deleteComment(user.getId(), commentId, articleId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "좋아요 체크 API")
    @UserAuthenticated
    @PostMapping("{articleId}/createdLike")
    public ResponseEntity<Void> saveLikes(User user,
                                          @PathVariable Long articleId) throws Exception {
        likeService.checkedLikes(user.getId(), articleId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "좋아요 삭제 API")
    @UserAuthenticated
    @DeleteMapping("{articleId}/deleteLike/{likeId}")
    public ResponseEntity<Void> deleteLikes(User user,
                                            @PathVariable Long articleId,
                                            @PathVariable Long likeId) {
        likeService.deletedLikes(user.getId(), articleId, likeId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "각 게시글 좋아요 모아보기 API")
    @UserAuthenticated
    @GetMapping("/likes/{articleId}")
    public ResponseEntity<Integer> getLikesForArticle(@PathVariable Long articleId) throws NotFoundException {
        int likesCount = articleService.getLikesForArticle(articleId);
        return ResponseEntity.ok().body(likesCount);
    }

}
