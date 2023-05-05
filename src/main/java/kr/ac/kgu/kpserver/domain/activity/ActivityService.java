package kr.ac.kgu.kpserver.domain.activity;

import kr.ac.kgu.kpserver.domain.activity.dto.ActivityDto;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.stress.goal.StressGoal;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserService;
import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;
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
    private final UserActivityRepository userActivityRepository;
    private final UserService userService;

    private static final int MAX_DAILY_ACTIVITY_COUNT = 3;

    @Transactional(readOnly = true)
    public List<ActivityDto> getDailyActivitiesByUser(User user) {
        List<UserActivity> userActivities = user.getUserActivities();
        return userActivities.stream()
                .map(UserActivity::getActivity)
                .map(ActivityDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void renewAllUserActivities() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            renewActivitiesByUser(user);
        }
    }

    @Transactional
    public void renewUserActivities(Long userId) {
        User user = userService.findUserByIdOrNull(userId);
        if (user == null) {
            throw new KpException(KpExceptionType.NOT_FOUND_USER);
        }
        renewActivitiesByUser(user);
    }

    private void renewActivitiesByUser(User user) {
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
        List<Activity> newActivities = activitiesByMBTI.subList(0, newActivitySize);
        List<UserActivity> userActivities = user.updateUserActivities(newActivities);
        userActivityRepository.deleteByUser(user);
        userActivityRepository.saveAll(userActivities);
    }
}
