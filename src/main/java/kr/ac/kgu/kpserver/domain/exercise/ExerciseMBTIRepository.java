package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseMBTIRepository extends JpaRepository<ExerciseMBTI, Long> {
    List<ExerciseMBTI> findByMbti(MBTI mbti);
}
