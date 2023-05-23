package kr.ac.kgu.kpserver.domain.exercise;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerStartupListener {

    private final ExerciseService exerciseService;

    public SchedulerStartupListener(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @Scheduled(cron = "0 0/2 * * * *") // 매일 자정에 실행
    public void setExerciseService() {
        exerciseService.solutionTypeNormal();
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void setExerciseServices() {
        exerciseService.solutionTypeHard();
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void setExerciseService1() {
        exerciseService.solutionTypeHigh();
    }
}