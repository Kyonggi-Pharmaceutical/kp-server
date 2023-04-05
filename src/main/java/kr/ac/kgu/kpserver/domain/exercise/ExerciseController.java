package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseRepository exerciseRepository;
    private final UserRepository userRepository;

    @Transactional
    @PostMapping("/api/v1/exercises")
    public ResponseEntity<Exercise> save(@RequestBody ExerciseDto exerciseDto) {
        Exercise exercise = new Exercise();
        exercise.setType(ExerciseType.valueOf(exerciseDto.getExerciseGroup()));
        exerciseRepository.save(exercise);

        User user = new User();
        user.setExerciseGroup(String.valueOf(exercise.getType()));
        userRepository.save(user);

        return ResponseEntity.ok(exercise);
    }


}

