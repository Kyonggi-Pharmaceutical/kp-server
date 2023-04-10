
package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.health.DailyProgress;
import kr.ac.kgu.kpserver.domain.health.DailyProgressRepository;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {
    private final UserRepository userRepository;
    @Autowired
    private ExerciseService exerciseService;
    private final DailyProgressRepository dailyProgressRepository;

    @UserAuthenticated
    @Transactional
    @PostMapping("/updateGroup")
    public ResponseEntity<?> saveUserExerciseGroup(@RequestBody UserDto userDto) {
        User users = exerciseService.saveExerciseGroup(userDto);

        return ResponseEntity.ok().body(users);
    }

    @UserAuthenticated
    @GetMapping("/exercisesInfo")
    @ResponseBody
    public ResponseEntity<?> solutionExercise(User user, Exercise exercise, UserDto userDto) {
//      ResponseEntity.ok().body(UserDto.from(user));

        Exercise exerciseSolution = exerciseService.solutionTypeExercise(user, exercise);
        // 사용자 몸무게 update -  Main 화면
        User users = new User();
        users.setWeight(userDto.getWeight());
        userRepository.save(users);

        return ResponseEntity.ok().body(exerciseSolution);
    }

    @UserAuthenticated
    @PostMapping("/exerciseChecked")
    public ResponseEntity<?> saveDailyProgress(@RequestBody boolean isCheck) {
        List<DailyProgress> dailyProgresses = dailyProgressRepository.findAll();
        for (DailyProgress dailyProgress : dailyProgresses) {
            dailyProgress.setDate(LocalDate.now());
            dailyProgress.setCheck(isCheck);
        }
        return ResponseEntity.ok(dailyProgresses);
    }

}
