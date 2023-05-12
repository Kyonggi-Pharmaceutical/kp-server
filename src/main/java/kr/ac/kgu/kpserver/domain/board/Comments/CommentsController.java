package kr.ac.kgu.kpserver.domain.board.Comments;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@Tag(name = "댓글 API")
@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentsController {
    private final CommentService commentService;

    @Operation(summary = "댓글 저장 API")
    @UserAuthenticated
    @PostMapping("/createdComment")
    public ResponseEntity<Void> saveComment(User user, Article article, @RequestBody CommentRequest commentRequest) {
        commentService.createdComments(user.getId(), article.getId(), commentRequest);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "댓글 수정 API")
    @UserAuthenticated
    @PutMapping("/updatedComment")
    public ResponseEntity<Void> updateComment(User user, Long commentId,
                                                 @RequestBody CommentRequest commentRequest) {
        commentService.updatedComments(user.getId(), commentId, commentRequest);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "댓글 삭제 API")
    @UserAuthenticated
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "사용자가 작성한 댓글의 게시물 보기 API")
    @UserAuthenticated
    @GetMapping("/myCommentLists")
    public ResponseEntity<List<Comment>> getCommentsByUser(User user, Long articleId) throws NotFoundException {
        List<Comment> comments = commentService.getCommentsByUser(user.getId(), articleId);
        return ResponseEntity.ok(comments);
    }


}
