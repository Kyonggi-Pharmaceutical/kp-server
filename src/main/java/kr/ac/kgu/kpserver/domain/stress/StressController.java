package kr.ac.kgu.kpserver.domain.stress;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.health.progress.DailyProgressService;
import kr.ac.kgu.kpserver.domain.stress.dto.StressGoalResponse;
import kr.ac.kgu.kpserver.domain.stress.goal.StressGoalService;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserService;
import kr.ac.kgu.kpserver.domain.user.dto.UserRequest;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "스트레스 관리 API")
@RestController
@RequestMapping("/api/v1/stresses")
public class StressController {

    private final DailyProgressService dailyProgressService;
    private final StressGoalService stressGoalService;
    private final UserService userService;

    public StressController(DailyProgressService dailyProgressService, StressGoalService stressGoalService, UserService userService) {
        this.dailyProgressService = dailyProgressService;
        this.stressGoalService = stressGoalService;
        this.userService = userService;
    }


    @Operation(summary = "스트레스 점수 업데이트 API")
    @UserAuthenticated
    @PutMapping("/stress-point")
    public ResponseEntity<Void> updateUserStressPoint(User user, @RequestParam int stressPoint) {
        UserRequest request = UserRequest.builder().stressPoint(stressPoint).build();
        userService.updateUser(user, request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "스트레스 관리 활동 일간 진척도 체크 API")
    @UserAuthenticated
    @PutMapping("/daily-progress")
    public ResponseEntity<Void> setStressDailyProgress(User user, @RequestParam boolean done) {
        dailyProgressService.setUserStressDailyProgress(user.getId(), done);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "스트레스 목표 조회 API")
    @UserAuthenticated
    @GetMapping("/stress-goal")
    public ResponseEntity<StressGoalResponse> getStressGoal(User user) {
        StressGoalResponse response = stressGoalService.getStressGoal(user.getId());
        return ResponseEntity.ok(response);
    }

    // TODO - 스트레스 월간 체크

}
