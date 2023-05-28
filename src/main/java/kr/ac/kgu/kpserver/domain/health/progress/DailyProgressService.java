package kr.ac.kgu.kpserver.domain.health.progress;

import kr.ac.kgu.kpserver.domain.health.HealthcareType;
import kr.ac.kgu.kpserver.domain.health.goal.HealthGoal;
import kr.ac.kgu.kpserver.domain.health.progress.dto.DailyProgressResponse;
import kr.ac.kgu.kpserver.domain.stress.goal.StressGoal;
import kr.ac.kgu.kpserver.domain.stress.goal.StressGoalRepository;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyProgressService {

    private final UserRepository userRepository;
    private final StressGoalRepository stressGoalRepository;
    private final DailyProgressRepository dailyProgressRepository;

    public DailyProgressService(UserRepository userRepository, StressGoalRepository stressGoalRepository, DailyProgressRepository dailyProgressRepository) {
        this.userRepository = userRepository;
        this.stressGoalRepository = stressGoalRepository;
        this.dailyProgressRepository = dailyProgressRepository;
    }

    @Transactional
    public void setUserStressDailyProgress(Long userId, boolean done) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new KpException(KpExceptionType.NOT_FOUND_USER));
        StressGoal stressGoal = user.getStressGoal();

        if (stressGoal.hasDailyProgress()) {
            throw new KpException(KpExceptionType.ALREADY_SET_DAILY_PROGRESS);
        }

        DailyProgress dailyProgress = new DailyProgress(done, stressGoal, user);
        stressGoal.addDailyProgress(dailyProgress);
        stressGoalRepository.save(stressGoal);
        dailyProgressRepository.save(dailyProgress);
    }

    @Transactional(readOnly = true)
    public List<DailyProgressResponse> getDailyProgressesUpToLastWeek(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new KpException(KpExceptionType.NOT_FOUND_USER));

        LocalDate now = LocalDate.now();
        LocalDate lastWeek = now.minusWeeks(1);

        if (user.getHealthcareType() == HealthcareType.HEALTH) {
            HealthGoal healthGoal = user.getHealthGoal();
            List<DailyProgress> dailyProgresses = healthGoal.getDailyProgresses().stream()
                    .filter(dailyProgress -> dailyProgress.getCreatedAt().isAfter(lastWeek.atStartOfDay()))
                    .collect(Collectors.toList());
            return DailyProgressResponse.from(dailyProgresses);
        }
        if (user.getHealthcareType() == HealthcareType.STRESS) {
            StressGoal stressGoal = user.getStressGoal();
            List<DailyProgress> dailyProgresses = stressGoal.getDailyProgresses().stream()
                    .filter(dailyProgress -> dailyProgress.getCreatedAt().isAfter(lastWeek.atStartOfDay()))
                    .collect(Collectors.toList());
            return DailyProgressResponse.from(dailyProgresses);
        }
        throw new KpException(KpExceptionType.INTERNAL_SERVER_ERROR);
    }
}
