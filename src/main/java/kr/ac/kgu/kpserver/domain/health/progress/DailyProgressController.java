package kr.ac.kgu.kpserver.domain.health.progress;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.health.progress.dto.DailyProgressResponse;
import kr.ac.kgu.kpserver.domain.health.progress.dto.DailyProgressCheckTodayResponse;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "일일 진척도 API")
@RestController
@RequestMapping("/api/v1/daily-progresses")
public class DailyProgressController {

    private final DailyProgressService dailyProgressService;

    public DailyProgressController(DailyProgressService dailyProgressService) {
        this.dailyProgressService = dailyProgressService;
    }


    @Operation(summary = "최근 1주일 일일 진척도 조회 API")
    @UserAuthenticated
    @GetMapping("/up-to-last-week")
    public ResponseEntity<List<DailyProgressResponse>> getDailyProgressesUpToLastWeek(User user) {
        List<DailyProgressResponse> dailyProgresses = dailyProgressService.getDailyProgressesUpToLastWeek(user.getId());
        return ResponseEntity.ok(dailyProgresses);
    }

    @Operation(summary = "오늘의 일일 진척도 체크 여부 조회 API")
    @UserAuthenticated
    @GetMapping("/is-check-today")
    public ResponseEntity<DailyProgressCheckTodayResponse> isCheckToday(User user) {
        DailyProgressCheckTodayResponse response = dailyProgressService.isCheckToday(user.getId());
        return ResponseEntity.ok(response);
    }

}
