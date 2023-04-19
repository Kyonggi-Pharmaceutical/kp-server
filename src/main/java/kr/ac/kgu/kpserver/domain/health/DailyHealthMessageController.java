package kr.ac.kgu.kpserver.domain.health;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "건강 메시지 API")
@RestController
@RequestMapping("/api/v1/daily-health-messages")
public class DailyHealthMessageController {

    private final DailyHealthMessageService dailyHealthMessageService;

    public DailyHealthMessageController(DailyHealthMessageService dailyHealthMessageService) {
        this.dailyHealthMessageService = dailyHealthMessageService;
    }

    @Operation(summary = "오늘의 건강 메시지 API")
    @UserAuthenticated
    @GetMapping
    public ResponseEntity<DailyHealthMessageDto> getDailyHealthMessage(User user) {
        DailyHealthMessageDto message = dailyHealthMessageService.getRandomMessageByUser(user);
        return ResponseEntity.ok(message);
    }
}
