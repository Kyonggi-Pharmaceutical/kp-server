package kr.ac.kgu.kpserver.domain.rank;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class Ranking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RankingPeriod period;
    @Enumerated(EnumType.STRING)
    private RankingType type;

}
