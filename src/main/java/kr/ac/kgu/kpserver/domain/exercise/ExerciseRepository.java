package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByMbti(MBTI mbti);
}
