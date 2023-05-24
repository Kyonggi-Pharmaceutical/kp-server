package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.health.UserAnswer;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
    @Autowired
    private final ExerciseMBTIRepository exerciseMBTIRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, UserRepository userRepository, UserExerciseRepository userExerciseRepository, ExerciseMBTIRepository exerciseMBTIRepository) {
        this.exerciseRepository = exerciseRepository;
        this.userExerciseRepository = userExerciseRepository;
        this.userRepository = userRepository;
        this.exerciseMBTIRepository = exerciseMBTIRepository;
    }

    private double roundToTwoDecimalPlaces(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Transactional
    public List<ExerciseDto> getDailyExercisesByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));
        LocalDate currentDate = LocalDate.now();
        Set<UserExercise> userExercises = userExerciseRepository.findAllByUserAndCreatedAtBetween(user,
                currentDate.atStartOfDay(), currentDate.atTime(LocalTime.MAX));

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
    @Scheduled(cron = "0 0/2 * * * *")
    public void renewForNormalUserExercises() {
        List<User> userList = userRepository.findByUserAnswer(UserAnswer.NORMAL);

        for (User user : userList) {
            renewExercisesForUser(user);
        }
    }

    private void renewExercisesForUser(User user) {
        MBTI userMBTI = user.getMbti();
        List<Long> exerciseIds = user.getUserExercises().stream()
                .map(UserExercise::getExercise)
                .map(Exercise::getId)
                .collect(Collectors.toList());

        List<Exercise> exercisesByMBTI = exerciseMBTIRepository.findByMbti(userMBTI).stream()
                .map(ExerciseMBTI::getExercise)
                .filter(exercise -> !exerciseIds.contains(exercise.getId()))
                .limit(1)
                .collect(Collectors.toList());
        if (!exercisesByMBTI.isEmpty()) {
            Exercise exercise = exercisesByMBTI.get(0);
            int time = 60;
            double metToCalories = exercise.getMet() * user.getWeight() * time / 60;
            double calories = roundToTwoDecimalPlaces(metToCalories);
            UserExercise userExercise = new UserExercise(user, exercise, calories, time);
            userExerciseRepository.save(userExercise);
        }
    }


    /*
     * 맞춤 운동 솔루션 제시(강도 낮춤)
     */

    @Scheduled(cron = "0 0 0 * * *")
    public void renewHardUserExercises() {
        List<User> userList = userRepository.findByUserAnswer(UserAnswer.HARD);

        for (User user : userList) {
            renewForHardUserExercises(user);
        }
    }

    public void renewForHardUserExercises(User user) {
        List<Long> exerciseIds = user.getUserExercises().stream()
                .map(UserExercise::getExercise)
                .map(Exercise::getId)
                .collect(Collectors.toList());
        List<Exercise> exercisesByMBTI = exerciseMBTIRepository.findByMbti(user.getMbti()).stream()
                .map(ExerciseMBTI::getExercise)
                .filter(exercise -> !exerciseIds.contains(exercise.getId()))
                .limit(1)
                .collect(Collectors.toList());

        int time = 30;
        double metToCalories = exercisesByMBTI.get(0).getMet() * user.getWeight() * time / 60;
        double calories = roundToTwoDecimalPlaces(metToCalories);
        UserExercise userExerciseSolution = new UserExercise(user, exercisesByMBTI.get(0), calories, time);
        userExerciseRepository.save(userExerciseSolution);
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void renewEasyUserExercises() {
        List<User> userList = userRepository.findByUserAnswer(UserAnswer.EASY);

        for (User user : userList) {
            renewForEasyUserExercises(user);
        }
    }

    public void renewForEasyUserExercises(User user) {

        List<Long> exerciseIds = user.getUserExercises().stream()
                .map(UserExercise::getExercise)
                .map(Exercise::getId)
                .collect(Collectors.toList());
        List<Exercise> exercisesByMBTI = exerciseMBTIRepository.findByMbti(user.getMbti()).stream()
                .map(ExerciseMBTI::getExercise)
                .filter(exercise -> !exerciseIds.contains(exercise.getId()))
                .limit(2)
                .collect(Collectors.toList());
        int time = 60;

        for (int i = 0; i < 2; i++) {
            Exercise exercise = exercisesByMBTI.get(i % exercisesByMBTI.size());
            double metToCalories = exercise.getMet() * user.getWeight() * time / 60;
            double calories = roundToTwoDecimalPlaces(metToCalories);
            UserExercise userExercise = new UserExercise(user, exercise, calories, time);
            userExerciseRepository.save(userExercise);
        }
    }

    @Transactional
    public void saveUserExerciseByMBTI(Long userId) throws NotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));
        List<Exercise> exercisesByMBTI = exerciseMBTIRepository.findByMbti(user.getMbti()).stream()
                .map(ExerciseMBTI::getExercise)
                .limit(2)
                .collect(Collectors.toList());
        int time = 60;
        double weight = user.getWeight();
        if (user.getUserAnswer().equals(UserAnswer.HARD)) {
            time /= 2;
        }

        List<UserExercise> userExercises = new ArrayList<>();

        if (user.getUserAnswer().equals(UserAnswer.EASY)) {
            for (int i = 0; i < 2; i++) {
                Exercise exercise = exercisesByMBTI.get(i % exercisesByMBTI.size());
                double metToCalories = exercise.getMet() * weight * time / 60;
                double calories = roundToTwoDecimalPlaces(metToCalories);
                UserExercise userExercise = new UserExercise(user, exercise, calories, time);
                userExercises.add(userExercise);
            }
        } else {
            Exercise exercise = exercisesByMBTI.get(0);
            double metToCalories = exercise.getMet() * weight * time / 60;
            double calories =roundToTwoDecimalPlaces(metToCalories);
            UserExercise userExercise = new UserExercise(user, exercise, calories, time);
            userExercises.add(userExercise);
        }

        userExerciseRepository.saveAll(userExercises);
    }
}