package kr.ac.kgu.kpserver.domain.health;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Tag(name = "목표 달성 API")
@RestController
@RequestMapping("/api/v1/health")
@RequiredArgsConstructor
public class HealthController {

    private final HealthService healthService;

    @Operation(summary = "사용자 목표 몸무게 저장 API")
    @UserAuthenticated
    @Transactional
    @PostMapping("/updateUserWeightGoal")
    public ResponseEntity<Void> saveUserExerciseGroup(@RequestBody HealthGoalDto healthGoalDto) {
        healthService.saveUserWeightGoal(healthGoalDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "일일 솔루션 체크 API")
    @UserAuthenticated
    @PostMapping("/dailyProgressChecked")
    public ResponseEntity<Void> saveDailyProgress(User user,
                                                  HealthGoal healthGoal,
                                                  Boolean isCheck) {
        healthService.saveDailyProgress(user, healthGoal, isCheck);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "월별 솔루션 달성률 제시 API")
    @UserAuthenticated
    @GetMapping("/monthAchievementRate")
    public ResponseEntity<HealthGoal> calculationMonthExerciseGoal(HealthGoal healthGoal) {
        HealthGoal healthGoal1 = healthService.calculationHealthGoal(healthGoal);
        return ResponseEntity.ok().body(healthGoal1);
    }

    @Operation(summary = "이전 솔루션 체크 리스트 확인 API")
    @UserAuthenticated
    @GetMapping("/checkedMyProgress")
    public ResponseEntity<DailyProgress> checkedMyProgress(List<DailyProgress> dailyProgresses) {
        DailyProgress dailyProgress = (DailyProgress) healthService.checkedMyProgress(dailyProgresses);
        return ResponseEntity.ok().body(dailyProgress);
    }

    @Operation(summary = "솔루션 만족시 API")
    @UserAuthenticated
    @PostMapping("/solutionSatisfaction")
    public ResponseEntity<Double> satisfactionSurveySatisfy(User user,
                                                            @RequestBody UserDto userDto,
                                                            HealthGoal healthGoal) {
        double resultWeight = healthService.satisfySurveySolution(user, userDto, healthGoal);
        healthService.saveEndSolutionDate(healthGoal);
        return ResponseEntity.ok().body(resultWeight);
    }
}
