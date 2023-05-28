package kr.ac.kgu.kpserver.domain.board.Comments;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CommentRequest {
    private Long id;
    private Long articleId;
    private String description;
    private Long userId;
    private String username;

    public static CommentRequest of(Comment comment) {
        return CommentRequest.builder()
                .id(comment.getId())
                .articleId(comment.getArticle().getId())
                .description(comment.getDescription())
                .username(comment.getUsername())
                .userId(comment.getUser().getId())
                .build();
    }

    public CommentRequest(String description){
        this.description = description;
    }
}
