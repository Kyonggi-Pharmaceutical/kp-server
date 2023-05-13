package kr.ac.kgu.kpserver.domain.rank;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.rank.dto.MBTIRankingResponse;
import kr.ac.kgu.kpserver.domain.rank.mbti.MBTIRanking;
import kr.ac.kgu.kpserver.domain.rank.mbti.MBTIRankingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "랭킹 API")
@RestController
@RequestMapping("/api/v1/ranking")
public class RankingController {

    private final MBTIRankingService mbtiRankingService;

    public RankingController(MBTIRankingService mbtiRankingService) {
        this.mbtiRankingService = mbtiRankingService;
    }

    @Operation(summary = "일간 MBTI 랭킹 API")
    @GetMapping("/mbti/daily")
    public ResponseEntity<List<MBTIRankingResponse>> getDailyMBTIRanking() {
        List<MBTIRanking> dailyRanking = mbtiRankingService.getDailyRanking();
        return ResponseEntity.ok(MBTIRankingResponse.from(dailyRanking));
    }

    @Operation(summary = "주간 MBTI 랭킹 API")
    @GetMapping("/mbti/weekly")
    public ResponseEntity<List<MBTIRankingResponse>> getWeeklyMBTIRanking() {
        List<MBTIRanking> dailyRanking = mbtiRankingService.getWeeklyRanking();
        return ResponseEntity.ok(MBTIRankingResponse.from(dailyRanking));
    }

    @Operation(summary = "월간 MBTI 랭킹 API")
    @GetMapping("/mbti/monthly")
    public ResponseEntity<List<MBTIRankingResponse>> getMonthlyMBTIRanking() {
        List<MBTIRanking> dailyRanking = mbtiRankingService.getMonthlyRanking();
        return ResponseEntity.ok(MBTIRankingResponse.from(dailyRanking));
    }

    @Operation(summary = "MBTI 랭킹 업데이트 (수동) API")
    @PostMapping("/mbti")
    public ResponseEntity<Void> createMBTIRanking() {
        mbtiRankingService.createMonthlyRanking();
        mbtiRankingService.createWeeklyRanking();
        mbtiRankingService.createDailyRanking();
        return ResponseEntity.ok().build();
    }

}
