package kr.ac.kgu.kpserver.domain.health;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.health.goal.HealthGoal;
import kr.ac.kgu.kpserver.domain.health.progress.DailyProgress;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Tag(name = "목표 달성 API")
@RestController
@RequestMapping("/api/v1/health")
@RequiredArgsConstructor
public class HealthController {

    private final HealthService healthService;
    private static final Logger logger = Logger.getLogger(HealthController.class.getName());
    @Operation(summary = "사용자 목표 몸무게 저장 API")
    @UserAuthenticated
    @PostMapping("/updateUserWeightGoal")
    public ResponseEntity<Void> saveUserExerciseGroup(@RequestBody HealthGoalDto healthGoalDto) {
        logger.info("운동목표 몸무게 api 호출");
        System.out.println("이거 모게~ ? " + healthGoalDto);
        healthService.saveUserWeightGoal(healthGoalDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "일일 솔루션 체크 API")
    @UserAuthenticated
    @PostMapping("/dailyProgressChecked")
    public ResponseEntity<Void> saveDailyProgress(User user,
                                                  Boolean isCheck) {
        healthService.saveDailyProgress(user, isCheck);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "월별 솔루션 달성률 제시 API")
    @UserAuthenticated
    @GetMapping("/monthAchievementRate")
    public ResponseEntity<Double> calculationMonthExerciseGoal(HealthGoal healthGoal) {
        Double accomplishRate = healthService.calculationHealthGoal(healthGoal);
        return ResponseEntity.ok(accomplishRate);
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
        return ResponseEntity.ok().body(resultWeight);
    }
}
