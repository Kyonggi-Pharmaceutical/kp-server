package kr.ac.kgu.kpserver.domain.board.Likes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.Articles.dto.ArticleDto;
import kr.ac.kgu.kpserver.domain.board.Comments.CommentRequest;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "좋아요 API")
@RestController
@RequestMapping("/api/v1/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @Operation(summary = "사용자별 좋아요 게시글 모아보기 API")
    @UserAuthenticated
    @GetMapping("/getLikedArticleByUser")
    public ResponseEntity<List<ArticleDto>> getLikedArticleForUser(User user) {
        List<ArticleDto> likedArticleByUser = likeService.getLikedArticleByUser(user.getId());
        return ResponseEntity.ok(likedArticleByUser);
    }

    @Operation(summary = "사용자별 좋아요 댓글 모아보기 API")
    @UserAuthenticated
    @GetMapping("/getLikedCommentByUser")
    public ResponseEntity<List<CommentRequest>> getLikedCommentForUser(User user) {
        List<CommentRequest> likedCommentByUser = likeService.getLikedCommentByUser(user.getId());
        return ResponseEntity.ok(likedCommentByUser);
    }
}

