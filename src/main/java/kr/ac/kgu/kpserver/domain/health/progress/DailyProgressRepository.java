package kr.ac.kgu.kpserver.domain.health.progress;

import kr.ac.kgu.kpserver.domain.health.goal.HealthGoal;
import kr.ac.kgu.kpserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DailyProgressRepository extends JpaRepository<DailyProgress, Long> {
    List<DailyProgress> findByUserAndHealthGoalAndCreatedAtBetween(User user, HealthGoal healthGoal, LocalDateTime start, LocalDateTime end);
    Optional<DailyProgress> findByUserAndCreatedAtBetween(User user, LocalDateTime from, LocalDateTime to);
}
