package kr.ac.kgu.kpserver.domain.board.Comments;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import kr.ac.kgu.kpserver.domain.board.Likes.LikeComment;
import kr.ac.kgu.kpserver.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;
    @OneToMany(mappedBy = "comment")
    private List<LikeComment> likes = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Comment(User user, Article article, String description, String username) {
        this.user = user;
        this.article = article;
        this.description = description;
        this.username = username;
    }
}
