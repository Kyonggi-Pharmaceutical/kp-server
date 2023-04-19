package kr.ac.kgu.kpserver.domain.health.message;

import kr.ac.kgu.kpserver.domain.health.Personality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyHealthMessageRepository extends JpaRepository<DailyHealthMessage, Long> {
    List<DailyHealthMessage> findByTypeAndPersonality(DailyHealthMessageType type, Personality personality);
}
