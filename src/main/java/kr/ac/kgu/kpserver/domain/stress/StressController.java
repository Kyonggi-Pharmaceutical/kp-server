package kr.ac.kgu.kpserver.domain.stress;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.health.progress.DailyProgressService;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "스트레스 관리 API")
@RestController
@RequestMapping("/api/v1/stresses")
public class StressController {

    private final DailyProgressService dailyProgressService;

    public StressController(DailyProgressService dailyProgressService) {
        this.dailyProgressService = dailyProgressService;
    }

    // TODO - 스트레스 점수 등록

    @Operation(summary = "스트레스 관리 활동 일간 진척도 체크 API")
    @UserAuthenticated
    @PutMapping("/daily-progress")
    public ResponseEntity<Void> setStressDailyProgress(User user, @RequestParam boolean done) {
        dailyProgressService.setUserStressDailyProgress(user.getId(), done);
        return ResponseEntity.ok().build();
    }

    // TODO - 스트레스 월간 체크

}
