package kr.ac.kgu.kpserver.domain.health;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthGoalRepository extends JpaRepository<HealthGoal, Long> {
}
