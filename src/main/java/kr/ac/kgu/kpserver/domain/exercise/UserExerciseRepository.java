package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserExerciseRepository extends JpaRepository<UserExercise, Long> {
   Set<UserExercise> findAllByUser(User user);
}
