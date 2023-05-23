package kr.ac.kgu.kpserver.domain.board.Comments;

import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import kr.ac.kgu.kpserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment>  findByArticle(Article article);
    List<Comment> findByUser(User user);
}
