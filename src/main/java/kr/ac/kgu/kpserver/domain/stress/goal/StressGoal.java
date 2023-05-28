package kr.ac.kgu.kpserver.domain.stress.goal;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "stress_goals")
@AllArgsConstructor
@NoArgsConstructor
public class StressGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss", timezone = "Asia/Seoul")
    private LocalDateTime startAt = LocalDateTime.now();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss", timezone = "Asia/Seoul")
    private LocalDateTime endAt = startAt.plusDays(30);

    private Double accomplishRate = 0.0;

    @OneToMany(mappedBy = "stressGoal")
    private List<DailyProgress> dailyProgresses = new ArrayList<>();

    public Double getAccomplishRate() {
        return accomplishRate == 0 ? updateAccomplishRate() : accomplishRate;
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
