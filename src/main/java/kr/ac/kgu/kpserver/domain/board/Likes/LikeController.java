package kr.ac.kgu.kpserver.domain.board.Likes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@Tag(name = "좋아요 API")
@RestController
@RequestMapping("/api/v1/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @Operation(summary = "좋아요 체크 API")
    @UserAuthenticated
    @PostMapping("/saveLikes")
    public ResponseEntity<Void> saveLikes(@RequestBody LikeRequest likeRequest) throws Exception {
        likeService.checkLikes(likeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "좋아요 삭제 API")
    @UserAuthenticated
    @PostMapping("/deleteLikes")
    public ResponseEntity<Void> deleteLikes(@RequestBody LikeRequest likeRequest) {
        likeService.deleteLikes(likeRequest);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "각 게시글 좋아요 모아보기 API")
    @UserAuthenticated
    @GetMapping("/{articleId}")
    public ResponseEntity<Integer> getLikesForArticle(@PathVariable Long articleId) throws NotFoundException {
        int likesCount = likeService.getLikesForArticle(articleId);
        return ResponseEntity.ok().body(likesCount);
    }

    @Operation(summary = "사용자별 좋아요 모아보기 API")
    @UserAuthenticated
    @GetMapping("/doLikedLists")
    public ResponseEntity<List<Article>> getLikesForUser(Long userId) throws NotFoundException {
        List<Article> likedArticle = likeService.getLikedArticlesForUser(userId);
        return ResponseEntity.ok().body(likedArticle);
    }
}
