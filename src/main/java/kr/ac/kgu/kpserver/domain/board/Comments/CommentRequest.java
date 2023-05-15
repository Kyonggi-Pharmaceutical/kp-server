package kr.ac.kgu.kpserver.domain.board.Comments;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    private String description;
    private boolean canEdit;

}
