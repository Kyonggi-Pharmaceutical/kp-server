package kr.ac.kgu.kpserver.domain.board.Comments;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import java.util.List;

@Tag(name = "댓글 API")
@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentsController {
    private final CommentService commentService;

    @Operation(summary = "사용자가 작성한 댓글의 게시물 보기 API")
    @UserAuthenticated
    @GetMapping("/myCommentLists")
    public ResponseEntity<List<Comment>> getCommentsByUser(User user, Long articleId) throws NotFoundException {
        List<Comment> comments = commentService.getCommentsByUser(user.getId(), articleId);
        return ResponseEntity.ok(comments);
    }


}
