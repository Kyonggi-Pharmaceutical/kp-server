package kr.ac.kgu.kpserver.domain.board.Likes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LikeDto {

    private Long userId;
    private Long articleId;

    public static LikeDto of(Like like) {
        return LikeDto.builder()
                .userId(like.getUser().getId())
                .articleId(like.getArticle().getId())
                .build();
    }
}
