package kr.ac.kgu.kpserver.domain.activity;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserActivityScheduler {

    private final ActivityService activityService;

    public UserActivityScheduler(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void renewUserActivities() {
        activityService.renewAllUserActivities();
    }
}
