package kr.ac.kgu.kpserver.domain.stress.goal;

import kr.ac.kgu.kpserver.domain.health.DailyProgress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "stress_goals")
@AllArgsConstructor
@NoArgsConstructor
public class StressGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double accomplishRate;

    @OneToMany(mappedBy = "stressGoal")
    private List<DailyProgress> dailyProgresses = new ArrayList<>();
}
