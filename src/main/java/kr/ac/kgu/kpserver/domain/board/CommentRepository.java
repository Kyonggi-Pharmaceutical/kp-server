package kr.ac.kgu.kpserver.domain.board;

import kr.ac.kgu.kpserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByArticle(Article article);
    List<Comment> findByUser(User user);
    Optional<Comment> findByUserAndArticle(User user, Article article);
}
