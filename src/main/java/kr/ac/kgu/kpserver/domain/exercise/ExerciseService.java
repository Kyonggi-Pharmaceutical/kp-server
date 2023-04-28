package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserAnswer;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserExerciseRepository userExerciseRepository;
    private User user;

    public ExerciseService(User user) {
        this.user = user;
    }

    protected List<Exercise> findAllExercises() {
        return exerciseRepository.findAll();
    }

    /*
     * 사용자 운동 타입, 몸무게 저장
     */
    public User saveExerciseGroup(User user, UserDto userDto) {
        String userExerciseGroup = userDto.getExerciseGroup();
        user.setExerciseGroup(userExerciseGroup);
        return userRepository.save(user);
    }

    public void normal() {
        List<User> users = userRepository.findByUserAnswer(UserAnswer.NORMAL);
        users.forEach(user -> {
            MBTI userMbti = user.getMbti();
            // 만족도가 보통인 유저에게 MBTI 에 맞춘 새로운 일일 솔루션 업데이트
            List<Exercise> exerciseListByMbti = exerciseRepository.findByMbti(userMbti);

            // 랜덤 운동 가져오기
            int randomIndex = new Random().nextInt(exerciseListByMbti.size());
            Exercise exercise = exerciseListByMbti.get(randomIndex);

            // 신규 일일 운동 save
        });
    }

    /*
     * 맞춤 운동 솔루션 제시(normal)
     */
    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public void solutionTypeNormal() {
        List<Exercise> allExercisesList = findAllExercises();
        List<Exercise> selectedExercises = allExercisesList.stream()
                .filter(e -> {
                    String personality = String.valueOf(e.getPersonality());
                    String userMBTI = String.valueOf(user.getMbti());
                    if (userMBTI.length() >= 1 && personality.length() >= 1) {
                        return personality.equals("ALL") || userMBTI.substring(0, 1).equals(personality.substring(0, 1));
                    } else {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        if (selectedExercises.isEmpty()) {
            return;
        }

        UserExercise userExerciseObject = new UserExercise();
        userExerciseObject.setUser(user);
        Exercise exercise = selectedExercises.get(0);
        userExerciseObject.setExercise(exercise);
        userExerciseRepository.save(userExerciseObject);
        selectedExercises.remove(0);


        List<UserExercise> userExercises = userExerciseRepository.findByUserOrderByCreatedAtAsc(user);
        userExercises.forEach(userExercise -> {
            Exercise exercises = userExercise.getExercise();
            exercises.updateCalories(user);
        });
    }

    /*
     * 맞춤 운동 솔루션 제시(강도 낮춤)
     */
    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public void solutionTypeHard() {
        List<Exercise> allExercisesList = findAllExercises();
        List<Exercise> selectedExercises = allExercisesList.stream()
                .filter(e -> {
                    String personality = String.valueOf(e.getPersonality());
                    String userMBTI = String.valueOf(user.getMbti());
                    if (userMBTI.length() >= 1 && personality.length() >= 1) {
                        return personality.equals("ALL") || userMBTI.substring(0, 1).equals(personality.substring(0, 1));
                    } else {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        if (selectedExercises.isEmpty()) {
            return;
        }

        UserExercise userExerciseObject = new UserExercise();
        userExerciseObject.setUser(user);
        Exercise exercise = selectedExercises.get(0);
        userExerciseObject.setExercise(exercise);
        userExerciseRepository.save(userExerciseObject);
        selectedExercises.remove(0);


        List<UserExercise> userExercises = userExerciseRepository.findByUserOrderByCreatedAtAsc(user);
        userExercises.forEach(userExercise -> {
            Exercise exercises = userExercise.getExercise();
            exercises.lowUpdateCalories(user);
        });
    }

    /*
     * 맞춤 운동 솔루션 제시(강도 높임)
     */
    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public void solutionTypeHigh() {
        List<Exercise> allExercisesList = findAllExercises();
        List<Exercise> selectedExercises = allExercisesList.stream()
                .filter(e -> {
                    String personality = String.valueOf(e.getPersonality());
                    String userMBTI = String.valueOf(user.getMbti());
                    if (userMBTI.length() >= 1 && personality.length() >= 1) {
                        return personality.equals("ALL") || userMBTI.substring(0, 1).equals(personality.substring(0, 1));
                    } else {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        if (selectedExercises.isEmpty()) {
            return;
        }


        List<Exercise> twoSelectedExercises = selectedExercises.stream()
                .limit(2)
                .collect(Collectors.toList());

        for (Exercise exercise : twoSelectedExercises) {
            UserExercise userExerciseObject = new UserExercise();
            userExerciseObject.setUser(user);
            userExerciseObject.setExercise(exercise);
            userExerciseRepository.save(userExerciseObject);
        }


        List<UserExercise> userExercises = userExerciseRepository.findByUserOrderByCreatedAtAsc(user);
        userExercises.forEach(userExercise -> {
            Exercise exercise = userExercise.getExercise();
            exercise.updateCalories(user);
        });
    }

}
