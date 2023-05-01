package kr.ac.kgu.kpserver.domain.exercise;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface UserExerciseRepository extends JpaRepository<UserExercise, Long> {

    UserExercise findByDate(LocalDate date);
}
