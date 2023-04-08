package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.health.Personality;
import kr.ac.kgu.kpserver.domain.user.User;
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
    private final Random random = new Random();

    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public Exercise solutionTypeExercise(User user, Exercise exercise) {
        String userMBTI = String.valueOf(user.getMbti());
        String exercisePersonality = String.valueOf(exercise.getPersonality());
        List<Exercise> exercises = new ArrayList<>();
        if (userMBTI.substring(0, 1).equals(exercisePersonality.substring(0, 1))) {
            Exercise exerciseList  = (Exercise) exerciseRepository.findByPersonality(Personality.valueOf(exercisePersonality));
            exercises.add(exerciseList);
        }

        if(exercises.isEmpty()){
            return null;
        }

        return exercises.get(random.nextInt(exercises.size()));
    }

}


