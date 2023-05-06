package kr.ac.kgu.kpserver.domain.board.Comments;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Operation(summary = "댓글 작성 API")
    @UserAuthenticated
    @PostMapping("/saveLikes")
    public ResponseEntity<Comment> saveComment(@RequestBody CommentRequest commentRequest) {
        Comment comment =  commentService.createComment(commentRequest);
        return ResponseEntity.ok(comment);
    }
    @Operation(summary = "댓글 수정 API")
    @UserAuthenticated
    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId,
                                                 @RequestBody CommentRequest commentRequest){
        Comment comment = commentService.updateComment(commentId,commentRequest);
        return ResponseEntity.ok(comment);
    }

    @Operation(summary = "댓글 삭제 API")
    @UserAuthenticated
    @DeleteMapping("/deleteLikes")
    public ResponseEntity<Void> deleteComment(@RequestBody CommentRequest commentRequest){
        commentService.deleteComment(commentRequest);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "사용자별 댓글 모아보기 API")
    @UserAuthenticated
    @GetMapping("/myCommentLists")
    public ResponseEntity<List<Comment>> getCommentsByUser(Long userId) throws NotFoundException {
        List<Comment> comments = commentService.getCommentsByUser(userId);
        return ResponseEntity.ok(comments);
    }

    @Operation(summary = "각 게시글 댓글 모아보기 API")
    @UserAuthenticated
    @GetMapping("/{articleId}")
    public ResponseEntity<List<Comment>> getCommentsForArticle(@RequestBody CommentRequest commentRequest) throws NotFoundException {
        List<Comment> comments = commentService.getCommentsForArticle(commentRequest.getArticleId());
        return ResponseEntity.ok(comments);
    }
}
