package kr.ac.kgu.kpserver.domain.board.Likes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import kr.ac.kgu.kpserver.domain.board.Articles.dto.ArticleDto;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "좋아요 API")
@RestController
@RequestMapping("/api/v1/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @Operation(summary = "좋아요 체크 API")
    @UserAuthenticated
    @PostMapping("/createdLike")
    public ResponseEntity<Void> saveLikes(User user, Long articleId) throws Exception {
        likeService.checkedLikes(user.getId(), articleId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "좋아요 삭제 API")
    @UserAuthenticated
    @DeleteMapping("/{likeId}")
    public ResponseEntity<Void> deleteLikes(User user, @PathVariable Long likeId) throws Exception {
        likeService.deletedLikes(user.getId(), likeId);
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "사용자별 좋아요 모아보기 API")
    @UserAuthenticated
    @GetMapping("/doLikedLists")
    public ResponseEntity<List<ArticleDto>> getLikesForUser(User user) throws NotFoundException {
        try {
            List<Article> likedArticles = likeService.getLikedArticlesForUser(user.getId());
            List<ArticleDto> likedArticleDtos = likedArticles.stream()
                    .map(ArticleDto::of)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(likedArticleDtos);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
