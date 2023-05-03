package kr.ac.kgu.kpserver.domain.board;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.user.User;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Builder
@Table(name = "likes")
@AllArgsConstructor
@NoArgsConstructor
public class Like extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "article_id")
    private Article article;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 날짜

    public Like(Article article, User user, LocalDate createDate) {
        this.article = article;
        this.user = user;
        this.createDate = createDate;
    }

}