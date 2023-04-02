package kr.ac.kgu.kpserver.domain.rank;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "mbti_ranking")
@AllArgsConstructor
@NoArgsConstructor
public class MBTIRanking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MBTI mbti;
    private Integer rank;

    // TODO - 랭킹 연관관계

}
