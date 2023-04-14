package kr.ac.kgu.kpserver.domain.health;

import io.swagger.v3.oas.annotations.Operation;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/health")
@RequiredArgsConstructor
public class HealthController {

    private final HealthService healthService;

    @Operation(description = "사용자 목표 몸무게 저장 API")
    @UserAuthenticated
    @Transactional
    @PostMapping("/updateUserWeightGoal")
    public ResponseEntity<HealthGoalDto> saveUserExerciseGroup(@RequestBody HealthGoalDto healthGoalDto) {
        healthService.saveUserWeightGoal(healthGoalDto);
        return ResponseEntity.ok().build();
    }
    @Operation(description = "일일 솔루션 체크 API")
    @UserAuthenticated
    @PostMapping("/dailyPorgressChecked")
    public ResponseEntity<Void> saveDailyProgress(User user,
                                                  HealthGoal healthGoal,  Boolean isCheck) {
        healthService.saveDailyProgress(user, healthGoal,isCheck);
        return ResponseEntity.ok().build();
    }

    @Operation(description = "월별 솔루션 달성률 제시 API")
    @UserAuthenticated
    @GetMapping("/monthAchievementRate")
    public ResponseEntity<HealthGoal> calculationMonthExerciseGoal(HealthGoal healthGoal) {

        HealthGoal healthGoal1 = healthService.calculationHealthGoal(healthGoal);
        return ResponseEntity.ok().body(healthGoal1);
    }

    @Operation(description = "이전 솔루션 체크 리스트 확인 API")
    @UserAuthenticated
    @GetMapping("/checkedMyProgress")
    public ResponseEntity<DailyProgress> checkedMyProgress(List<DailyProgress> dailyProgresses){
        DailyProgress dailyProgress = (DailyProgress) healthService.checkedMyProgress(dailyProgresses);
        return ResponseEntity.ok().body(dailyProgress);
    }
    @Operation(description = "솔루션 만족시 API")
    @UserAuthenticated
    @PostMapping
    public ResponseEntity<Map<String, Object>> satisfactionSurveySatisfy(User user,
                                                  @RequestBody UserDto userDto,
                                                  HealthGoal healthGoal){
        String userExerciseGroup = user.getExerciseGroup();
        double resultWeight = healthService.satisfySurveySolution(user, userDto, healthGoal);

        Map<String, Object> response = new HashMap<>();
        response.put("userExerciseGroup", userExerciseGroup);
        response.put("resultWeight", resultWeight);

        return ResponseEntity.ok().body(response);
    }
/*미완
*
* */
    @Operation(description = "솔루션 불만족 API")
    @UserAuthenticated
    @PostMapping
    public ResponseEntity<?> SatisfactionSurveyDissatisfy(){

        return ResponseEntity.ok().build();
    }


}
