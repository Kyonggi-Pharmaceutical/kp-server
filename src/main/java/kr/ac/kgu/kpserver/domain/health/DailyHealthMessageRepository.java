package kr.ac.kgu.kpserver.domain.health;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyHealthMessageRepository extends JpaRepository<DailyHealthMessage, Long> {
    public List<DailyHealthMessage> findByTypeAndPersonality(DailyHealthMessageType type, Personality personality);
}
