package kr.ac.kgu.kpserver.domain.stress.dto;

import kr.ac.kgu.kpserver.domain.health.progress.dto.DailyProgressResponse;
import kr.ac.kgu.kpserver.domain.stress.goal.StressGoal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StressGoalResponse {

    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Double accomplishRate;
    private List<DailyProgressResponse> dailyProgresses;

    public static StressGoalResponse of(StressGoal stressGoal) {
        return StressGoalResponse.builder()
                .startAt(stressGoal.getStartAt())
                .endAt(stressGoal.getEndAt())
                .accomplishRate(stressGoal.getAccomplishRate())
                .dailyProgresses(DailyProgressResponse.from(stressGoal.getDailyProgresses()))
                .build();
    }
}
