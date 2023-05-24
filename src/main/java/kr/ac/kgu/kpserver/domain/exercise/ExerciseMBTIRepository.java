package kr.ac.kgu.kpserver.domain.exercise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseMBTIRepository extends JpaRepository<UserExercise, Long> {
//    List<ExerciseMBTI> findByMbti(MBTI mbti);
}
