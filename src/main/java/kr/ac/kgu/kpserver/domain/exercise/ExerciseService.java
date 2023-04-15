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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private UserRepository userRepository;
    private final Random random = new Random();

    protected List<Exercise> findAllExercises() {
        return exerciseRepository.findAll();
    }

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
     * 맞춤 운동 솔루션 제시(normal)
     */
    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public ExerciseDto solutionTypeNormal(User user,
                                           Exercise exercise,
                                           ExerciseDto exerciseDto) {
        List<Exercise> allExercisesList = findAllExercises();
        List<Exercise> selectedExercises = new ArrayList<>();

        for (Exercise exerciseList : allExercisesList) {
            String userMBTI = String.valueOf(user.getMbti());
            String exercisePersonality = String.valueOf(exercise.getPersonality());
            if (userMBTI.substring(0, 1).equals(exercisePersonality.substring(0, 1)) || exercisePersonality.equals("ALL")) {
                selectedExercises.add(exerciseList);
            }
        }

        if (selectedExercises.isEmpty()) {
            return null;
        }

        Exercise selectExerciseList = selectedExercises.get(random.nextInt(selectedExercises.size()));
        selectExerciseList.updateCalories(user);
        return exerciseDto.mapToDto(selectExerciseList);
    }

    /*
     * 맞춤 운동 솔루션 제시(강도 낮춤)
     */
    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public ExerciseDto solutionTypeHard(User user,
                                        Exercise exercise,
                                        ExerciseDto exerciseDto) {
        List<Exercise> allExercisesList = findAllExercises();
        List<Exercise> selectedExercises = new ArrayList<>();

        for (Exercise exerciseList : allExercisesList) {
            String userMBTI = String.valueOf(user.getMbti());
            String exercisePersonality = String.valueOf(exercise.getPersonality());
            if (userMBTI.substring(0, 1).equals(exercisePersonality.substring(0, 1)) || exercisePersonality.equals("ALL")) {
                selectedExercises.add(exerciseList);
            }
        }

        if (selectedExercises.isEmpty()) {
            return null;
        }

        Exercise selectExerciseList = selectedExercises.get(random.nextInt(selectedExercises.size()));
        selectExerciseList.lowUpdateCalories(user);

        return exerciseDto.mapToDto(selectExerciseList);
    }

    /*
     * 맞춤 운동 솔루션 제시(강도 높임)
     */
    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public List<ExerciseDto> solutionTypeHigh(User user,
                                              Exercise exercise,
                                              ExerciseDto exerciseDto) {
        List<Exercise> allExercisesList = findAllExercises();
        List<Exercise> selectedExercises = new ArrayList<>();

        for (Exercise exerciseList : allExercisesList) {
            String userMBTI = String.valueOf(user.getMbti());
            String exercisePersonality = String.valueOf(exercise.getPersonality());
            if (userMBTI.substring(0, 1).equals(exercisePersonality.substring(0, 1)) || exercisePersonality.equals("ALL")) {
                selectedExercises.add(exerciseList);
            }
        }

        if (selectedExercises.isEmpty()) {
            return null;
        }

        return selectedExercises.stream()
                .limit(2)
                .map(exerciseDto::mapToDto)
                .collect(Collectors.toList());
    }
}