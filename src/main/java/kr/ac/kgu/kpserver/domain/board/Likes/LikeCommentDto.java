package kr.ac.kgu.kpserver.domain.board.Likes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LikeCommentDto {

    private Long id;
    private Long userId;
    private Long commentId;
    public static LikeCommentDto of(LikeComment like) {
        return LikeCommentDto.builder()
                .id(like.getId())
                .userId(like.getUser().getId())
                .commentId(like.getComment().getId())
                .build();
    }
}
