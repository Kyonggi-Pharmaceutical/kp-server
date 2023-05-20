package kr.ac.kgu.kpserver.domain.rank.all;

import kr.ac.kgu.kpserver.domain.rank.Ranking;
import kr.ac.kgu.kpserver.domain.rank.RankingType;
import kr.ac.kgu.kpserver.domain.rank.period.RankingPeriod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "all_ranking")
@AllArgsConstructor
@NoArgsConstructor
public class AllRanking extends Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String nickname;
    private Integer rankScore;
    private Double progressRate;

    public AllRanking(Long userId, String nickname, Integer rankScore, RankingPeriod period, RankingType type, LocalDate targetDate, Double progressRate) {
        this.userId = userId;
        this.nickname = nickname;
        this.rankScore = rankScore;
        this.setPeriod(period);
        this.setType(type);
        this.setTargetDate(targetDate);
        this.progressRate = progressRate;
    }
}
