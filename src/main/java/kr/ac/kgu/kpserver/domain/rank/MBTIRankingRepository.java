package kr.ac.kgu.kpserver.domain.rank;

import kr.ac.kgu.kpserver.domain.rank.dto.MBTIRankingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MBTIRankingRepository extends JpaRepository<MBTIRanking, Long> {

    @Query("SELECT new kr.ac.kgu.kpserver.domain.rank.dto.MBTIRankingDto(u.mbti, COUNT(*), SUM(CASE WHEN dp.isCheck = true THEN 1 ELSE 0 END)) " +
            "FROM User u " +
            "INNER JOIN u.healthGoal.dailyProgresses dp " +
            "WHERE dp.createdAt between ?1 and ?2 " +
            "GROUP BY u.mbti")
    List<MBTIRankingDto> findMBTIDailyProgressCheckedCountBetween(LocalDateTime from, LocalDateTime to);

}
