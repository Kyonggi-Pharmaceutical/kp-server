package kr.ac.kgu.kpserver.domain.exercise;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Tag(name = "운동 API")
@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {
    @Autowired
    private final ExerciseService exerciseService;
    @Operation(summary = "사용자 운동 타입 저장 API")
    @UserAuthenticated
    @Transactional
    @PostMapping("/updateGroup")
    public ResponseEntity<?> saveUserExerciseGroup(@RequestBody UserDto userDto) {
        User users = exerciseService.saveExerciseGroup(userDto);
        return ResponseEntity.ok().body(users);
    }
    @Operation(summary = "일일 운동 솔루션 제시 API")
    @UserAuthenticated
    @GetMapping("/exercisesSolution")
    @ResponseBody
    public ResponseEntity<ExerciseDto> solutionExerciseDefault(User user,
                                                               ExerciseDto exerciseDto) {
        ExerciseDto exerciseSolution =
                exerciseService.solutionTypeNormal(user,exerciseDto);

        return ResponseEntity.ok(exerciseSolution);
    }
    @Operation(summary = "일일 운동 솔루션 제시(강도 낮음) API")
    @UserAuthenticated
    @GetMapping("/lowExercisesSolution")
    @ResponseBody
    public ResponseEntity<ExerciseDto> solutionExerciseHard(ExerciseDto exerciseDto,
                                                            User user){
        ExerciseDto lowExerciseSolution =
                exerciseService.solutionTypeHard(user, exerciseDto);
        return ResponseEntity.ok(lowExerciseSolution);
    }
    @Operation(summary = "일일 운동 솔루션 제시(강도 높음) API")
    @UserAuthenticated
    @GetMapping("/highExercisesSolution")
    @ResponseBody
    public ResponseEntity<List<ExerciseDto>> solutionExerciseHigh(ExerciseDto exerciseDto,
                                                                  User user){
        List<ExerciseDto> highExerciseSolution =
                exerciseService.solutionTypeHigh(user, exerciseDto);
        return ResponseEntity.ok(highExerciseSolution);
    }

}
