package kr.ac.kgu.kpserver.domain.board;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.board.dto.ArticleDto;
import kr.ac.kgu.kpserver.domain.board.dto.CommentRequest;
import kr.ac.kgu.kpserver.domain.board.dto.CreateArticleRequest;
import kr.ac.kgu.kpserver.domain.board.dto.LikeRequest;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "게시글 API")
@RestController
@RequestMapping("/api/v1/community")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @Operation(summary = "스트레스 게시글 모아보기 API")
    @UserAuthenticated
    @GetMapping("/stress")
    public ResponseEntity<Page<ArticleDto>> getStress(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        Page<Article> stressCategory = boardService.getArticlesByCategory(BoardCategory.STRESS, PageRequest.of(page, size));
        Page<ArticleDto> stressCategoryDto = stressCategory.map(ArticleDto::from);
        return ResponseEntity.ok(stressCategoryDto);
    }

    @Operation(summary = "운동 게시글 모아보기 API")
    @UserAuthenticated
    @GetMapping("/exercise")
    public ResponseEntity<Page<ArticleDto>> getExercise(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        Page<Article> exerciseCategory = boardService.getArticlesByCategory(BoardCategory.WEIGHT, PageRequest.of(page, size));
        Page<ArticleDto> exerciseCategoryDto = exerciseCategory.map(ArticleDto::from);
        return ResponseEntity.ok(exerciseCategoryDto);
    }

    @Operation(summary = "게시글 작성 API")
    @UserAuthenticated
    @PostMapping("/postCreated")
    public ResponseEntity<ArticleDto> postBoard(@RequestBody CreateArticleRequest createArticleRequest,
                                                Article article) {
        Article savedBoard = boardService.updateArticle(article, createArticleRequest);
        return ResponseEntity.ok(ArticleDto.from(savedBoard));
    }

    @Operation(summary = "게시글 수정 API")
    @UserAuthenticated
    @PutMapping("/updateArticle")
    public ResponseEntity<ArticleDto> putBoard(Article article,
                                               @Valid @RequestBody CreateArticleRequest createArticleRequest) {

        Article savedBoard = boardService.updateArticle(article, createArticleRequest);
        return ResponseEntity.ok(ArticleDto.from(savedBoard));
    }

    @Operation(summary = "게시글 삭제 API")
    @UserAuthenticated
    @DeleteMapping("/deleteArticle")
    public ResponseEntity<Void> deleteArticle(Article article) {
        boardService.deleteArticle(article);
        return ResponseEntity.ok().build();
    }
    @Operation(summary = "댓글 작성 API")
    @UserAuthenticated
    @PostMapping("/saveLikes")
    public ResponseEntity<Comment> saveComment(@RequestBody CommentRequest commentRequest) {
        Comment comment =  boardService.createComment(commentRequest);
        return ResponseEntity.ok(comment);
    }
    @Operation(summary = "댓글 수정 API")
    @UserAuthenticated
    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId,
                                                 @RequestBody CommentRequest commentRequest){
        Comment comment =  boardService.updateComment(commentId,commentRequest);
        return ResponseEntity.ok(comment);
    }

    @Operation(summary = "댓글 삭제 API")
    @UserAuthenticated
    @DeleteMapping("/deleteLikes")
    public ResponseEntity<Void> deleteComment(@RequestBody CommentRequest commentRequest){
        boardService.deleteComment(commentRequest);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "각 게시글 좋아요 모아보기 API")
    @UserAuthenticated
    @GetMapping("/{articleId}")
    public ResponseEntity<List<Comment>> getCommentsForArticle(@RequestBody CommentRequest commentRequest) throws NotFoundException {
        List<Comment> comments = boardService.getCommentsForArticle(commentRequest.getArticleId());
        return ResponseEntity.ok(comments);
    }
    @Operation(summary = "사용자별 댓글 모아보기 API")
    @UserAuthenticated
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Comment>> getCommentsByUser(@PathVariable Long userId) throws NotFoundException {
        List<Comment> comments = boardService.getCommentsByUser(userId);
        return ResponseEntity.ok(comments);
    }

    @Operation(summary = "좋아요 체크 API")
    @UserAuthenticated
    @PostMapping("/saveLikes")
    public ResponseEntity<Void> saveLikes(@RequestBody LikeRequest likeRequest) throws Exception {
        boardService.checkLikes(likeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @Operation(summary = "좋아요 삭제 API")
    @UserAuthenticated
    @PostMapping("/deleteLikes")
    public ResponseEntity<Void> deleteLikes(@RequestBody LikeRequest likeRequest){
        boardService.deleteLikes(likeRequest);
        return ResponseEntity.ok().build();
    }
    @Operation(summary = "각 게시글 좋아요 모아보기 API")
    @UserAuthenticated
    @GetMapping("/{articleId}")
    public ResponseEntity<Integer> getLikesForArticle(@PathVariable Long articleId) throws NotFoundException {
        int likesCount = boardService.getLikesForArticle(articleId);
        return ResponseEntity.ok().body(likesCount);
    }

    @Operation(summary = "사용자별 좋아요 모아보기 API")
    @UserAuthenticated
    @GetMapping("/{userId}")
    public ResponseEntity<List<Article>> getLikesForUser(@PathVariable("userId") Long userId) throws NotFoundException {
        List<Article> likedArticle =  boardService.getLikedArticlesForUser(userId);
        return ResponseEntity.ok().body(likedArticle);
    }
}