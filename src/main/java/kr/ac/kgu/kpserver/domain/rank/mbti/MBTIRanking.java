package kr.ac.kgu.kpserver.domain.rank.mbti;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
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
@Table(name = "mbti_ranking")
@AllArgsConstructor
@NoArgsConstructor
public class MBTIRanking extends Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MBTI mbti;
    private Integer rankScore;

    public MBTIRanking(MBTI mbti, Integer rankScore, RankingPeriod period, RankingType type, LocalDate targetDate) {
        this.mbti = mbti;
        this.rankScore = rankScore;
        this.setPeriod(period);
        this.setType(type);
        this.setTargetDate(targetDate);
    }
}
