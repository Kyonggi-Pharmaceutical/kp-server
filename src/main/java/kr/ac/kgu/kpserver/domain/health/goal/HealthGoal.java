package kr.ac.kgu.kpserver.domain.health.goal;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.health.HealthcareType;
import kr.ac.kgu.kpserver.domain.health.progress.DailyProgress;
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
    private HealthcareType type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss", timezone = "Asia/Seoul")
    private LocalDateTime startAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss", timezone = "Asia/Seoul")
    private LocalDateTime endAt;
    private Double accomplishRate;
    private Double weightGoal;
    @OneToMany(mappedBy = "healthGoal")
    private List<DailyProgress> dailyProgresses = new ArrayList<>();

    public HealthGoal(LocalDateTime startAt,
                      Double weightGoal,
                      HealthcareType type) {
        this.startAt = startAt;
        this.weightGoal = weightGoal;
        this.type = type;
    }

    public void addDailyProgress(DailyProgress dailyProgress) {
        dailyProgresses.add(dailyProgress);
        updateAccomplishRate();
    }

    public boolean hasDailyProgress() {
        return dailyProgresses.stream().anyMatch(dailyProgress ->
                dailyProgress.getCreatedAt().getDayOfYear() == LocalDateTime.now().getDayOfYear()
        );
    }
    private double updateAccomplishRate() {
        long checkedCount = dailyProgresses.stream().filter(DailyProgress::getIsCheck).count();
        double value = checkedCount / 30.0 * 100;
        this.accomplishRate = Math.round(value * 10) / 10.0;
        return this.accomplishRate;
    }
}
