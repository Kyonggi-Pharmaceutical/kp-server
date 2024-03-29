package kr.ac.kgu.kpserver.domain.health;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.health.progress.dto.DailyProgressResponse;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

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
    public ResponseEntity<Void> saveUserExerciseGroup(User user,
                                                      @RequestBody HealthGoalDto healthGoalDto) {
        healthService.saveHealthGoalWithUser(user.getId(), healthGoalDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "일일 솔루션 체크 저장 API")
    @UserAuthenticated
    @PostMapping("/dailyProgressChecked")
    public ResponseEntity<Void> saveDailyProgress(User user,
                                                  @RequestBody DailyProgressResponse dailyProgressResponse) {
        healthService.saveDailyProgress(user.getId(), dailyProgressResponse);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "일일 솔루션 체크 API")
    @UserAuthenticated
    @GetMapping("/printDailyProgress")
    public ResponseEntity<Boolean> printDailyProgress(User user) {
        boolean TrueValues = healthService.displayDailyProgress(user.getId());
        return ResponseEntity.ok().body(TrueValues);
    }

    @Operation(summary = "월별 솔루션 달성률 제시 API")
    @UserAuthenticated
    @GetMapping("/monthAchievementRate")
    public ResponseEntity<HealthGoalDto> calculationMonthExerciseGoal(User user) {
        HealthGoalDto healthGoalDto = healthService.getAccomplishRate(user.getId());
        return ResponseEntity.ok(healthGoalDto);
    }

    @Operation(summary = "이전 솔루션 체크 리스트 확인 API")
    @UserAuthenticated
    @GetMapping("/checkedMyProgress")
    public ResponseEntity<List<DailyProgressResponse>> checkedMyProgress(User user) {
        try {
            List<DailyProgressResponse> trueDates = healthService.checkedMyProgress(user.getId());
            return ResponseEntity.ok(trueDates);
        } catch (
                Exception e) {
            logger.warning("일일 솔루션 체크 API 실행 중 오류 발생: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "솔루션 만족시 API")
    @UserAuthenticated
    @GetMapping("/solutionSatisfaction")
    public ResponseEntity<Double> satisfactionSurveySatisfy(User user) {
        double resultWeight = healthService.satisfySurveySolution(user.getId());
        return ResponseEntity.ok().body(resultWeight);
    }
    @Operation(summary = "사용자 불만족시 응답 타입 저장 API")
    @UserAuthenticated
    @PostMapping("/saveUserAnswer")
    public ResponseEntity<Void> saveUserAnswer(User user,
                                               @RequestBody UserDto userDto) {
        healthService.findByUserAnswer(user.getId(), userDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "건강 목표 조회 API")
    @UserAuthenticated
    @GetMapping("/health-goal")
    public ResponseEntity<HealthGoalDto> getHealthGoal(User user) {
        HealthGoalDto healthGoal = healthService.getHealthGoal(user.getId());
        return ResponseEntity.ok(healthGoal);
    }

}
