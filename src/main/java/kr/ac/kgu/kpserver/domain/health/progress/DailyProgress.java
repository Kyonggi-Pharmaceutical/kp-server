package kr.ac.kgu.kpserver.domain.health.progress;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.health.goal.HealthGoal;
import kr.ac.kgu.kpserver.domain.stress.goal.StressGoal;
import kr.ac.kgu.kpserver.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "daily_progresses")
@AllArgsConstructor
@NoArgsConstructor
public class DailyProgress extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isCheck;
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "health_goal_id")
    private HealthGoal healthGoal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stress_goal_id")
    private StressGoal stressGoal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public DailyProgress(Boolean isCheck,
                         HealthGoal healthGoal,
                         StressGoal stressGoal,
                         User user) {
        this.isCheck = isCheck;
        this.healthGoal = healthGoal;
        this.stressGoal = stressGoal;
        this.user = user;
    }

    public DailyProgress(Boolean isCheck, StressGoal stressGoal, User user) {
        this.isCheck = isCheck;
        this.stressGoal = stressGoal;
        this.user = user;
    }
}
