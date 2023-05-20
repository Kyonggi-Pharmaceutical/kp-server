package kr.ac.kgu.kpserver.domain.exercise;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "운동 API")
@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Operation(summary = "사용자 운동 메인 API")
    @UserAuthenticated
    @GetMapping("/exerciseSolution")
    public ResponseEntity<List<ExerciseDto>> getDailyExercises(User user) {
        List<ExerciseDto> dailyExercises = exerciseService.getDailyExercisesByUser(user.getId());
        return ResponseEntity.ok(dailyExercises);
    }

    @Operation(summary = "초기 운동 저장 API")
    @UserAuthenticated
    @PostMapping("/saveUserExercise")
    public ResponseEntity<Void> getFirstUserExercise(User user){
        exerciseService.saveUserExerciseByMBTI(user.getId());
        return ResponseEntity.ok().build();
    }


}