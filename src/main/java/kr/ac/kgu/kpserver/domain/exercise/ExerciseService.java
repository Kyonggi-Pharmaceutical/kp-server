package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.health.UserAnswer;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

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

    @Transactional
    public List<ExerciseDto> getDailyExercisesByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));
        Set<UserExercise> userExercises = userExerciseRepository.findAllByUser(user);

        return userExercises.stream()
                .map(userExercise -> {
                    Exercise exercise = exerciseRepository.findById(userExercise.getExercise().getId())
                            .orElseThrow(() -> new NotFoundException("Could not find exercise with id: " + userExercise.getExercise().getId()));
                    return ExerciseDto.from(exercise, userExercise.getCal(), userExercise.getTime());
                })
                .collect(Collectors.toList());
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
            int time = 60;
            double metToCalories = exercise.getMet() * user.getWeight() * time / 60;
            double calories = Math.round(metToCalories * 100) / 100.0; // 칼로리 계산
            UserExercise userExerciseSolution = new UserExercise(user, exercise, calories, time); // 칼로리 추가
            userExerciseRepository.save(userExerciseSolution);
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

                    int time = 30;
                    double metToCalories = exercise.getMet() * user.getWeight() * time / 60;
                    double calories = Math.round(metToCalories * 100) / 100.0; // 칼로리 계산
                    UserExercise userExerciseSolution = new UserExercise(user, exercise, calories, time); // 칼로리 추가
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

                int time = 60;
                double metToCalories = exercise.getMet() * user.getWeight() * 60 / 60;
                double calories = Math.round(metToCalories * 100) / 100.0;
                UserExercise userExerciseSolution = new UserExercise(user, exercise, calories, time); // 칼로리 추가
                userExerciseRepository.save(userExerciseSolution);
            }
        });
    }

    public void saveUserExerciseByMBTI(Long userId) throws NotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));
        MBTI userMBTI = user.getMbti();
        Exercise exercise = exerciseRepository.findByMbti(userMBTI)
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Could not find exercise for MBTI: " + userMBTI));
        if (user.getUserAnswer().equals(UserAnswer.HARD)) {
            int time = 30;
            double metToCalories = exercise.getMet() * user.getWeight() * time / 60;
            double cal = Math.round(metToCalories * 100) / 100.0;
            UserExercise userExercise = new UserExercise(user, exercise, cal, time);
            userExerciseRepository.save(userExercise);
        } else {
            int time = 60;
            double metToCalories = exercise.getMet() * user.getWeight() * time / 60;
            double cal = Math.round(metToCalories * 100) / 100.0;
            UserExercise userExercise = new UserExercise(user, exercise, cal, time);
            userExerciseRepository.save(userExercise);
        }
    }
}
