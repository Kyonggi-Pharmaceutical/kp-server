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
                                          ExerciseDto exerciseDto) {
        List<Exercise> allExercisesList = findAllExercises();
        List<Exercise> selectedExercises = new ArrayList<>();

        String userMBTI = String.valueOf(user.getMbti());

        allExercisesList.stream()
                .filter(e -> {
                    String personality = String.valueOf(e.getPersonality());
                    return personality.equals("ALL") || userMBTI.substring(0, 1).equals(personality.substring(0, 1));
                })
                .forEach(selectedExercises::add);

        if (selectedExercises.isEmpty()) {
            return null;
        }

        Exercise selectExerciseList = selectedExercises.get(random.nextInt(selectedExercises.size()));
        selectExerciseList.updateCalories(user);
        exerciseRepository.save(selectExerciseList);
        return exerciseDto.mapToDto(selectExerciseList);
    }

    /*
     * 맞춤 운동 솔루션 제시(강도 낮춤)
     */
    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public ExerciseDto solutionTypeHard(User user,
                                        ExerciseDto exerciseDto) {
        List<Exercise> allExercisesList = findAllExercises();
        List<Exercise> selectedExercises = new ArrayList<>();

        String userMBTI = String.valueOf(user.getMbti());

        allExercisesList.stream()
                .filter(e -> {
                    String personality = String.valueOf(e.getPersonality());
                    return personality.equals("ALL") || userMBTI.substring(0, 1).equals(personality.substring(0, 1));
                })
                .forEach(selectedExercises::add);

        if (selectedExercises.isEmpty()) {
            return null;
        }

        Exercise selectExerciseList = selectedExercises.get(random.nextInt(selectedExercises.size()));
        selectExerciseList.lowUpdateCalories(user);
        exerciseRepository.save(selectExerciseList);
        return exerciseDto.mapToDto(selectExerciseList);
    }

    /*
     * 맞춤 운동 솔루션 제시(강도 높임)
     */
    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public List<ExerciseDto> solutionTypeHigh(User user,
                                              ExerciseDto exerciseDto) {
        List<Exercise> allExercisesList = findAllExercises();
        List<Exercise> selectedExercises = new ArrayList<>();

        String userMBTI = String.valueOf(user.getMbti());

        allExercisesList.stream()
                .filter(e -> {
                    String personality = String.valueOf(e.getPersonality());
                    return personality.equals("ALL") || userMBTI.substring(0, 1).equals(personality.substring(0, 1));
                })
                .forEach(selectedExercises::add);

        if (selectedExercises.isEmpty()) {
            return null;
        }

        List<ExerciseDto> exerciseDtos = selectedExercises.stream()
                .limit(2)
                .map(exerciseDto::mapToDto)
                .collect(Collectors.toList());

        List<Exercise> exercisesToSave = exerciseDtos.stream()
                .map(exerciseDto::mapToEntity)
                .collect(Collectors.toList());

        exerciseRepository.saveAll(exercisesToSave);

        return exerciseDtos;
    }

}