package kr.ac.kgu.kpserver.domain.activity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.activity.dto.ActivityDto;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "스트레스 솔루션 API")
@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @Operation(summary = "오늘의 스트레스 솔루션 조회")
    @UserAuthenticated
    @GetMapping("/daily-solutions")
    public ResponseEntity<List<ActivityDto>> getDailyActivities(User user) {
        List<ActivityDto> dailyActivities = activityService.getDailyActivitiesByUser(user);
        return ResponseEntity.ok(dailyActivities);
    }

    @Operation(summary = "오늘의 스트레스 솔루션 업데이트(수동) API")
    @PostMapping("/daily-solutions/renew")
    public ResponseEntity<Void> renew() {
        activityService.renewAllUserActivities();
        return ResponseEntity.ok().build();
    }
}
