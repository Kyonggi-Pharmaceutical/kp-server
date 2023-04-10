
package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.health.DailyProgress;
import kr.ac.kgu.kpserver.domain.health.HealthGoal;
import kr.ac.kgu.kpserver.domain.health.HealthGoalRepository;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private HealthGoalRepository healthGoalRepository;

    @Autowired
    private UserRepository userRepository;
    private final Random random = new Random();

    public User saveExerciseGroup(UserDto userDto) {
        User user = new User();
        user.setExerciseGroup(userDto.getExerciseGroup());
        return userRepository.save(user);
    }

    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public Exercise solutionTypeExercise(User user, Exercise exercise) {

        List<Exercise> allExercises = exerciseRepository.findAll();
        List<Exercise> selectedExercises = new ArrayList<>();

        for (Exercise exerciseList : allExercises) {
            String userMBTI = String.valueOf(user.getMbti());
            String exercisePersonality = String.valueOf(exercise.getPersonality());
            if (userMBTI.substring(0, 1).equals(exercisePersonality.substring(0, 1)) || exercisePersonality.equals("ALL")) {
                selectedExercises.add(exerciseList);
            }
        }

        if (selectedExercises.isEmpty()) {
            return null;
        }


        return selectedExercises.get(random.nextInt(selectedExercises.size()));
    }

    //메소드 생성만 한 상태
    public List<HealthGoal> isCheckedDailyGoal(List<DailyProgress> dailyProgresses) {

        long trueCount = dailyProgresses.stream().filter(DailyProgress::isCheck).count();
        double accomplishRate = (double) trueCount / dailyProgresses.size();

        List<HealthGoal> healthGoals = healthGoalRepository.findAll();
        for (HealthGoal h : healthGoals) {
            h.setAccomplishRate(accomplishRate);
        }
        int lastIdx = healthGoals.size() - 1;
        healthGoalRepository.save(healthGoals.get(lastIdx));

        return healthGoals;

    }

}

