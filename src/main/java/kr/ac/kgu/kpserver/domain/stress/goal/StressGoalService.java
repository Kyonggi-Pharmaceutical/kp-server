package kr.ac.kgu.kpserver.domain.stress.goal;

import kr.ac.kgu.kpserver.domain.stress.dto.StressGoalResponse;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StressGoalService {

    private final UserRepository userRepository;

    public StressGoalService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public StressGoalResponse getStressGoal(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new KpException(KpExceptionType.NOT_FOUND_USER));
        StressGoal stressGoal = user.getStressGoal();
        return StressGoalResponse.of(stressGoal);
    }

}