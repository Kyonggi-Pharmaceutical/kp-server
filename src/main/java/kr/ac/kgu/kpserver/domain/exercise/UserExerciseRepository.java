package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserExerciseRepository extends JpaRepository<UserExercise, Long> {

    List<UserExercise> findByUserOrderByCreatedAtAsc(User user);
}
