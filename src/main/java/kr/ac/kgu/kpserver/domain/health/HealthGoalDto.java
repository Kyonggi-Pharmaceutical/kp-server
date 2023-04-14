package kr.ac.kgu.kpserver.domain.health;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HealthGoalDto {
    private SurveyType answer;
    private Double weightGoal;
}
