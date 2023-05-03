package kr.ac.kgu.kpserver.domain.board;

import kr.ac.kgu.kpserver.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByLikesUser(User user);
    Page<Article> findByBoard(BoardCategory category, Pageable pageable);
}
