package kr.ac.kgu.kpserver.domain.health;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.ac.kgu.kpserver.domain.health.goal.HealthGoal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HealthGoalDto {
    private Double weightGoal;
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Seoul")
    private LocalDateTime startAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Seoul")
    private LocalDateTime endAt;
    private Double accomplishRate;
    private HealthcareType type;
    private UserAnswer userAnswer;

    public static HealthGoalDto of(HealthGoal healthGoal, UserAnswer userAnswer) {
        return new HealthGoalDto(
                healthGoal.getWeightGoal(),
                healthGoal.getStartAt(),
                healthGoal.getEndAt(),
                healthGoal.getAccomplishRate(),
                healthGoal.getType(),
                userAnswer
        );
    }
    public static HealthGoalDto from(HealthGoal healthGoal) {
        return HealthGoalDto.builder().
                weightGoal(healthGoal.getWeightGoal())
                .accomplishRate(healthGoal.getAccomplishRate())
                .type(healthGoal.getType())
                .build();
    }
}
