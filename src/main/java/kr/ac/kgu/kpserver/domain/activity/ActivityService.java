package kr.ac.kgu.kpserver.domain.activity;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.stress.goal.StressGoal;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityMBTIRepository activityMBTIRepository;
    private final UserService userService;

    private static final int MAX_DAILY_ACTIVITY_COUNT = 5;

    @Transactional
    public void renewAllUserActivities() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            MBTI userMbti = user.getMbti();
            StressGoal stressGoal = user.getStressGoal();
            if (stressGoal == null) {
                return;
            }
            List<Activity> currentActivities = user.getUserActivities().stream()
                    .map(UserActivity::getActivity)
                    .collect(Collectors.toList());
            List<Activity> activitiesByMBTI = activityMBTIRepository.findByMbti(userMbti).stream()
                    .map(ActivityMBTI::getActivity)
                    .filter(activity -> !currentActivities.contains(activity))
                    .collect(Collectors.toList());

            Collections.shuffle(activitiesByMBTI);
            int newActivitySize = Math.min(activitiesByMBTI.size(), MAX_DAILY_ACTIVITY_COUNT);
            List<Activity> newActivities = activitiesByMBTI.subList(0, newActivitySize - 1);
            user.updateUserActivities(newActivities);
        }
    }
}
