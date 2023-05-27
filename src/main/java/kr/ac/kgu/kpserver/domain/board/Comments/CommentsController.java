package kr.ac.kgu.kpserver.domain.board.Comments;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.Likes.LikeService;
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
    private final LikeService likeService;

    @Operation(summary = "사용자가 작성한 댓글의 게시물 보기 API")
    @UserAuthenticated
    @GetMapping("/getCommentsByUser")
    public ResponseEntity<List<CommentRequest>> getCommentsByUser(User user) throws NotFoundException {
        List<CommentRequest> comments = commentService.getCommentsByUser(user.getId());
        return ResponseEntity.ok(comments);
    }

    @Operation(summary = "댓글 좋아요 API")
    @UserAuthenticated
    @PostMapping("/{commentId}/likes")
    public ResponseEntity<Void> addLikeForComment( @PathVariable Long commentId, User user) {
        likeService.addLikeForComment(user.getId(), commentId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "댓글 좋아요 API")
    @UserAuthenticated
    @PostMapping("/{commentId}/deleteLikes")
    public ResponseEntity<Void> deleteLikeForComment( @PathVariable Long commentId, User user) {
        likeService.deleteLikeForComment(user.getId(), commentId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "댓글 좋아요 유지 API")
    @UserAuthenticated
    @GetMapping("/{commentId}/maintainLikesForComments")
    public ResponseEntity<Boolean> maintainLikesForComments(User user, @PathVariable Long commentId) throws NotFoundException {
        boolean tureValues = likeService.maintainLikesForComments(user.getId(), commentId);
        return ResponseEntity.ok(tureValues);
    }

    @Operation(summary = "댓글 좋아요 유지 API")
    @UserAuthenticated
    @GetMapping("/{commentId}/likes")
    public ResponseEntity<Integer> getLikesForComment(@PathVariable Long commentId) {
        try {
            int likesCount = likeService.getLikesForComment(commentId);
            return ResponseEntity.ok(likesCount);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
