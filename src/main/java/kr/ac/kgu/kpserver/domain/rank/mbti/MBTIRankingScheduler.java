package kr.ac.kgu.kpserver.domain.rank.mbti;

import kr.ac.kgu.kpserver.domain.rank.mbti.MBTIRankingService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MBTIRankingScheduler {

    private final MBTIRankingService mbtiRankingService;

    public MBTIRankingScheduler(MBTIRankingService mbtiRankingService) {
        this.mbtiRankingService = mbtiRankingService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void createDailyMBTIRanking() {
        mbtiRankingService.createDailyRanking();
    }

    @Scheduled(cron = "0 0 0 * * MON")
    public void createWeeklyMBTIRanking() {
        mbtiRankingService.createWeeklyRanking();
    }

    @Scheduled(cron = "0 0 0 1 1/1 *")
    public void createMonthlyMBTIRanking() {
        mbtiRankingService.createMonthlyRanking();
    }
}
