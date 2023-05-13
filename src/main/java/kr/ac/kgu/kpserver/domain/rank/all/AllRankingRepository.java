package kr.ac.kgu.kpserver.domain.rank.all;

import kr.ac.kgu.kpserver.domain.rank.dto.UserCheckedCountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

interface AllRankingRepository extends JpaRepository<AllRanking, Long> {

    @Query("SELECT new kr.ac.kgu.kpserver.domain.rank.dto.UserCheckedCountDto(u.id, u.nickname, COUNT(*), SUM(CASE WHEN dp.isCheck = true THEN 1 ELSE 0 END)) " +
            "FROM User u " +
            "INNER JOIN u.healthGoal.dailyProgresses dp " +
            "WHERE dp.createdAt between ?1 and ?2 " +
            "GROUP BY u")
    List<UserCheckedCountDto> findUserDailyProgressCheckedCountBetween(LocalDateTime from, LocalDateTime to);

    List<AllRanking> findByTargetDate(LocalDate targetDate);
}
