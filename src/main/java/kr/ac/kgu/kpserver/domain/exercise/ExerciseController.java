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
import java.time.LocalDate;
import java.util.logging.Logger;

@Tag(name = "운동 API")
@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {
    @Autowired
    private final ExerciseService exerciseService;
    private static final Logger logger = Logger.getLogger(ExerciseController.class.getName());

    @Operation(summary = "사용자 운동 메인 API")
    @UserAuthenticated
    @Transactional
    @GetMapping("/exerciseSolution")
    public ResponseEntity<UserExercise> saveUserExerciseGroup(@RequestParam(required = false) LocalDate date) {
        if (date == null) {
            date = LocalDate.now(); // set default value to today's date
        }
        UserExercise userExerciseList =exerciseService.printExercise(date);
        logger.info("운동 메인 api 호출"+ userExerciseList.getExercise());
        logger.info("운동 메인 api 호출"+ userExerciseList.getUser());
        return ResponseEntity.ok(userExerciseList);
    }

    @Operation(summary = "사용자 만족도 타입 저장 API")
    @UserAuthenticated
    @Transactional
    @PostMapping("/saveUserAnswer")
    public ResponseEntity<Void> saveUserAnswer(User user, UserDto userDto) {
        exerciseService.findByUserAnswer(user, userDto);
        return ResponseEntity.ok().build();
    }



}