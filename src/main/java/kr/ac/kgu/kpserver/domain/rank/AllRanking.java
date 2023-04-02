package kr.ac.kgu.kpserver.domain.rank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "all_ranking")
@AllArgsConstructor
@NoArgsConstructor
public class AllRanking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rank;

    // TODO - 랭킹 연관관계
    // TODO - 유저 연관관계

}
