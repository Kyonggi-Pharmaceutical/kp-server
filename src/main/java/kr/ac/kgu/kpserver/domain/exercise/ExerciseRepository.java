package kr.ac.kgu.kpserver.domain.exercise;

import java.util.List;

import kr.ac.kgu.kpserver.domain.health.Personality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findByPersonality(Personality personality);
}
