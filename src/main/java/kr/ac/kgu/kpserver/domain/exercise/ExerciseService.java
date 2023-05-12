package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.health.UserAnswer;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExerciseService {
    @Autowired
    private final ExerciseRepository exerciseRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserExerciseRepository userExerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, UserRepository userRepository, UserExerciseRepository userExerciseRepository) {
        this.exerciseRepository = exerciseRepository;
        this.userExerciseRepository = userExerciseRepository;
        this.userRepository = userRepository;

    }

    Logger logger = LoggerFactory.getLogger(ExerciseService.class);
    @Transactional
    public void findByUserAnswer(User user, UserDto userDto) {
        String userAnswer = String.valueOf(userDto.getUserAnswer());
        user.setUserAnswer(UserAnswer.valueOf(userAnswer));
        userRepository.save(user);
    }

    /*
     * met -> calories
     * */

    private double calculateCaloriesToNormalAndEasy(Exercise exercise, User user) {
        double metToCalories = exercise.getMet() * user.getWeight() * 60 / 60;
        return Math.round(metToCalories * 100) / 100.0;
    }

    private double calculateCaloriesToEasy(Exercise exercise, User user) {
        double metToCalories = exercise.getMet() * user.getWeight() * 30 / 60;
        return Math.round(metToCalories * 100) / 100.0;
    }

    /*
     * 맞춤 운동 솔루션 제시(normal)
     */
    @Transactional
    public void solutionTypeNormal() {
        List<User> userList = userRepository.findByUserAnswer(UserAnswer.NORMAL);

        userList.forEach(user -> {
            MBTI userMBTI = user.getMbti();
            List<Long> exerciseIds = user.getUserExercises().stream()
                    .map(UserExercise::getExercise)
                    .map(Exercise::getId)
                    .collect(Collectors.toList());

            List<Exercise> exercisesList = Optional.ofNullable(exerciseRepository.findByMbtiAndIdNotIn(userMBTI, exerciseIds))
                    .orElse(Collections.emptyList());

            int randomIdx = new Random().nextInt(exercisesList.size());
            Exercise exercise = exercisesList.get(randomIdx);
            logger.info(exercise.toString());
            double calories = calculateCaloriesToNormalAndEasy(exercise, user); // 칼로리 계산
            UserExercise userExerciseSolution = new UserExercise(user, exercise, calories); // 칼로리 추가
            userExerciseRepository.save(userExerciseSolution);
            logger.info(userExerciseSolution.toString());
        });
    }

    /*
     * 맞춤 운동 솔루션 제시(강도 낮춤)
     */
    @Transactional
    public void solutionTypeHard() {
        List<User> userList = userRepository.findByUserAnswer(UserAnswer.HARD);
        userList.forEach(user -> {
                    MBTI userMBTI = user.getMbti();
                    List<Long> exerciseIds = user.getUserExercises().stream()
                            .map(UserExercise::getExercise)
                            .map(Exercise::getId)
                            .collect(Collectors.toList());
                    List<Exercise> exercisesList = exerciseRepository
                            .findByMbtiAndIdNotIn(userMBTI, exerciseIds);

                    int randomIdx = new Random().nextInt(exercisesList.size());
                    Exercise exercise = exercisesList.get(randomIdx);


                    double calories = calculateCaloriesToEasy(exercise, user); // 칼로리 계산
                    UserExercise userExerciseSolution = new UserExercise(user, exercise, calories); // 칼로리 추가
                    userExerciseRepository.save(userExerciseSolution);
                }
        );
    }

    /*
     * 맞춤 운동 솔루션 제시(강도 높임)
     */
    @Transactional
    public void solutionTypeHigh() {
        List<User> userList = userRepository.findByUserAnswer(UserAnswer.EASY);
        userList.forEach(user -> {
            MBTI userMBTI = user.getMbti();
            List<Long> exerciseIds = user.getUserExercises().stream()
                    .map(UserExercise::getExercise)
                    .map(Exercise::getId)
                    .collect(Collectors.toList());
            List<Exercise> exercisesList = exerciseRepository.findByMbtiAndIdNotIn(userMBTI, exerciseIds);


            for (int i = 0; i < 2; i++) {
                int randomIdx = new Random().nextInt(exercisesList.size());
                Exercise exercise = exercisesList.get(randomIdx);

                double calories = calculateCaloriesToNormalAndEasy(exercise, user); // 칼로리 계산
                UserExercise userExerciseSolution = new UserExercise(user, exercise, calories); // 칼로리 추가
                userExerciseRepository.save(userExerciseSolution);
            }
        });
    }

    @Transactional
    public List<ExerciseDto> getDailyExercisesByUser(User user) {
        Set<UserExercise> userExercise = user.getUserExercises();
        return userExercise.stream()
                .map(userEx -> {
                    ExerciseDto exerciseDto = ExerciseDto.from(userEx.getExercise());
                    exerciseDto.setCal(userEx.getCal());
                    return exerciseDto;
                })
                .collect(Collectors.toList());
    }
}
