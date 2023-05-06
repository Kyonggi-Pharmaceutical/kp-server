package kr.ac.kgu.kpserver.domain.board.Likes;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeRequest {
    private Long userId;
    private Long articleId;
}
