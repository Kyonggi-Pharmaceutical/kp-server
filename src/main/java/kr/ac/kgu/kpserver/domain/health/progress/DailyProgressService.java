package kr.ac.kgu.kpserver.domain.health.progress;

import kr.ac.kgu.kpserver.domain.stress.goal.StressGoal;
import kr.ac.kgu.kpserver.domain.stress.goal.StressGoalRepository;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
