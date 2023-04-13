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
public class AllRanking extends Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Integer rankScore;

}
