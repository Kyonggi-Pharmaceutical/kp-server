package kr.ac.kgu.kpserver.domain.rank.all;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AllRankingScheduler {

    private final AllRankingService allRankingService;

    public AllRankingScheduler(AllRankingService allRankingService) {
        this.allRankingService = allRankingService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void createDailyAllRanking() {
        allRankingService.createDailyRanking();
    }

    @Scheduled(cron = "0 0 0 * * MON")
    public void createWeeklyAllRanking() {
        allRankingService.createWeeklyRanking();
    }

    @Scheduled(cron = "0 0 0 1 1/1 *")
    public void createMonthlyAllRanking() {
        allRankingService.createMonthlyRanking();
    }
}
