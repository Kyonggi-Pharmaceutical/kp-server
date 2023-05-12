package kr.ac.kgu.kpserver.domain.health.progress.dto;

import kr.ac.kgu.kpserver.domain.health.HealthcareType;
import kr.ac.kgu.kpserver.domain.health.progress.DailyProgress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyProgressResponse {

    private LocalDate date;
    private HealthcareType type;
    private Boolean isCheck;

    public static DailyProgressResponse of(DailyProgress dailyProgress) {
        LocalDate date = dailyProgress.getCreatedAt().toLocalDate();
        HealthcareType type = (dailyProgress.getHealthGoal() == null) ? HealthcareType.STRESS : HealthcareType.HEALTH;

        return DailyProgressResponse.builder()
                .date(date)
                .type(type)
                .isCheck(dailyProgress.isCheck())
                .build();
    }

    public static List<DailyProgressResponse> from(List<DailyProgress> dailyProgresses) {
        return dailyProgresses.stream()
                .map(DailyProgressResponse::of)
                .collect(Collectors.toList());
    }
}
