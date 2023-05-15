package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByMbtiAndIdNotIn(MBTI mbti, List<Long> excludeExerciseIds);
    Optional<Exercise> findFirstByMbtiOrderByCreatedAt(MBTI mbti);
}
