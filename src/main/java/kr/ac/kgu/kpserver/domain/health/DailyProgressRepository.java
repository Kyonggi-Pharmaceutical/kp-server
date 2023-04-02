package kr.ac.kgu.kpserver.domain.health;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyProgressRepository extends JpaRepository<DailyProgress, Long> {
}
