package kr.ac.kgu.kpserver.domain.exercise;

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
    private UserRepository userRepository;
    private final Random random = new Random();

    /*
     * 사용자 운동 타입, 몸무게 저장
     */
    public User saveExerciseGroup(UserDto userDto) {
        User user = new User();
        user.setExerciseGroup(userDto.getExerciseGroup());
        user.setWeight(userDto.getWeight());
        return userRepository.save(user);
    }

    /*
     * 맞춤 운동 솔루션 제시
     */
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
}