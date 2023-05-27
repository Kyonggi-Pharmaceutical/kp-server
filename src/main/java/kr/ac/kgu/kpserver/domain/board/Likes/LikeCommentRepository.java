package kr.ac.kgu.kpserver.domain.board.Likes;

import kr.ac.kgu.kpserver.domain.board.Comments.Comment;
import kr.ac.kgu.kpserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {
    List<LikeComment> findByUser(User user);
    Optional<LikeComment> findByUserAndComment(User user, Comment comment);
    List<LikeComment> findAllByComment(Comment comment);
    void deleteByComment(Comment comment);
}