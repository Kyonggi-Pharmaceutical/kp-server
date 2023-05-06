package kr.ac.kgu.kpserver.domain.board.Comments;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    private Long userId;
    private Long articleId;
    private String description;

}
