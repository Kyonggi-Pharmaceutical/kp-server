package kr.ac.kgu.kpserver.domain.exercise;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@Tag(name = "운동 API")
@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;
    private static final Logger logger = Logger.getLogger(ExerciseController.class.getName());

    @Operation(summary = "사용자 운동 메인 API")
    @UserAuthenticated
    @GetMapping("/exerciseSolution")
    public ResponseEntity<List<ExerciseDto>> getDailyExercises(User user) {
        List<ExerciseDto> dailyExercises = exerciseService.getDailyExercisesByUser(user);
        logger.info(String.valueOf(dailyExercises.size()));
        return ResponseEntity.ok(dailyExercises);
    }

    @Operation(summary = "사용자 만족도 타입 저장 API")
    @UserAuthenticated
    @PostMapping("/saveUserAnswer")
    public ResponseEntity<Void> saveUserAnswer(User user, UserDto userDto) {
        exerciseService.findByUserAnswer(user, userDto);
        return ResponseEntity.ok().build();
    }


}