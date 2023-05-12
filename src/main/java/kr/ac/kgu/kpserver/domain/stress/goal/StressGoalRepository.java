package kr.ac.kgu.kpserver.domain.stress.goal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StressGoalRepository extends JpaRepository<StressGoal, Long> {
}
