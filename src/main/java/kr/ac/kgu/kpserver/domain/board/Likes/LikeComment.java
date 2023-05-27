package kr.ac.kgu.kpserver.domain.board.Likes;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.board.Comments.Comment;
import kr.ac.kgu.kpserver.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Builder
@Table(name = "like_comment")
@AllArgsConstructor
@NoArgsConstructor
public class LikeComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;


    public LikeComment(User user,  Comment comment) {
        this.user = user;
        this.comment = comment;
    }
}
