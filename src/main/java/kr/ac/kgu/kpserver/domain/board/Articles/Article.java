package kr.ac.kgu.kpserver.domain.board.Articles;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.board.Board;
import kr.ac.kgu.kpserver.domain.board.Comments.Comment;
import kr.ac.kgu.kpserver.domain.board.Likes.Like;
import kr.ac.kgu.kpserver.domain.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "articles")
@AllArgsConstructor
@NoArgsConstructor
public class Article extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 100)
    private String title;
    @NotBlank
    @Size(max = 500)
    private String description;
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "article")
    private List<Like> likes = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Article(String title, String description, User user, Board board, String username) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.board = board;
        this.username = username;
    }

    public void addComments(Comment comment) {
        comments.add(comment);
        comment.setArticle(this);
    }

}
