package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
public class ExerciseController {
    private final UserRepository userRepository;
    @Autowired
    private ExerciseService exerciseService;

    @UserAuthenticated
    @Transactional
    @PostMapping("/api/v1/exercises")
    public ResponseEntity<?> saveUserExerciseGroup(User user, @RequestBody UserDto userDto) {
        ResponseEntity.ok().body(UserDto.from(user));

        User users = new User();
        users.setExerciseGroup(userDto.getExerciseGroup());
        userRepository.save(users);
        return ResponseEntity.ok().build();
    }
    @UserAuthenticated
    @GetMapping("api/v1/exercises")
    public ResponseEntity<?> solutionExercise(User user, Exercise exercise) {
        ResponseEntity.ok().body(UserDto.from(user));

        Exercise exerciseSolution = exerciseService.solutionTypeExercise(user, exercise);
        return ResponseEntity.ok().body(exerciseSolution);
    }

}