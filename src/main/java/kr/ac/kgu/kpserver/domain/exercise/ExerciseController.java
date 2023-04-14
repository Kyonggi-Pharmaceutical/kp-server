package kr.ac.kgu.kpserver.domain.exercise;

import io.swagger.v3.oas.annotations.Operation;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {
    @Autowired
    private final ExerciseService exerciseService;
    @Operation(description = "사용자 운동 타입 저장 API")
    @UserAuthenticated
    @Transactional
    @PostMapping("/updateGroup")
    public ResponseEntity<?> saveUserExerciseGroup(@RequestBody UserDto userDto) {
        User users = exerciseService.saveExerciseGroup(userDto);
        return ResponseEntity.ok().body(users);
    }
    @Operation(description = "일일 운동 솔루션 제시 API")
    @UserAuthenticated
    @GetMapping("/exercisesSolution")
    @ResponseBody
    public ResponseEntity<?> solutionExerciseMain(User user, Exercise exercise) {
        Exercise exerciseSolution = exerciseService.solutionTypeExercise(user, exercise);

        return ResponseEntity.ok().body(exerciseSolution);
    }
}