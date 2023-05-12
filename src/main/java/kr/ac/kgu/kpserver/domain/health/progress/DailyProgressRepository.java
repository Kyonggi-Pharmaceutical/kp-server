package kr.ac.kgu.kpserver.domain.health.progress;

import kr.ac.kgu.kpserver.domain.health.goal.HealthGoal;
import kr.ac.kgu.kpserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DailyProgressRepository extends JpaRepository<DailyProgress, Long> {
    List<DailyProgress> findByUserAndHealthGoalAndDateBetween(User user, HealthGoal healthGoal, LocalDateTime start, LocalDateTime end);
}

