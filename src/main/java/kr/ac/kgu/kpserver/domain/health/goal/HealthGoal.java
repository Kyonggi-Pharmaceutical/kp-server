package kr.ac.kgu.kpserver.domain.health.goal;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.health.DailyProgress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "health_goals")
@AllArgsConstructor
@NoArgsConstructor
public class HealthGoal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private HealthGoalType type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss", timezone = "Asia/Seoul")
    private LocalDateTime startAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss", timezone = "Asia/Seoul")
    private LocalDateTime endAt;
    private Double accomplishRate;
    private Double weightGoal;
    @OneToMany(mappedBy = "healthGoal")
    private List<DailyProgress> dailyProgresses = new ArrayList<>();

}
