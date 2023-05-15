package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserExerciseRepository extends JpaRepository<UserExercise, Long> {
    Optional<UserExercise> findByUser(User user);
}
