
package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.health.DailyProgress;
import kr.ac.kgu.kpserver.domain.health.DailyProgressRepository;
import kr.ac.kgu.kpserver.domain.health.HealthGoal;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {
    private final UserRepository userRepository;
    private final DailyProgressRepository dailyProgressRepository;

//    private final HealthGoalRepository healthGoalRepository;
    @Autowired
    private final ExerciseService exerciseService;

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
    public ResponseEntity<?> solutionExerciseMain(User user,
                                                  Exercise exercise,
                                                  UserDto userDto,
                                                  List<DailyProgress> dailyProgresses) {
//      ResponseEntity.ok().body(UserDto.from(user));

       Exercise exerciseSolution =  exerciseService.solutionTypeExercise(user, exercise);
        // 사용자 몸무게 update -  Main 화면
        user.setWeight(userDto.getWeight());
        userRepository.save(user);
        // 캘렌더 표시 - 오늘 날짜 이전
        List<String> checkList = dailyProgresses.stream()
                .filter(dp -> dp.getDate().isBefore(LocalDate.now()))
                .map(dp -> dp.isCheck() ? "완료" : "미완료")
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("user", user);
        response.put("exercise", exerciseSolution);
        response.put("checkList", checkList);

        return ResponseEntity.ok().body(response);
    }

    @UserAuthenticated
    @PostMapping("/exerciseChecked")
    public ResponseEntity<?> saveDailyProgress(@RequestBody boolean isCheck) {
        List<DailyProgress> dailyProgresses = dailyProgressRepository.findAll();
        for (DailyProgress dailyProgress : dailyProgresses) {
            dailyProgress.setDate(LocalDate.now());
            dailyProgress.setCheck(isCheck);
            dailyProgressRepository.save(dailyProgress);
        }
        return ResponseEntity.ok(dailyProgresses);
    }

    @UserAuthenticated
    @GetMapping("/doExercise")
    public ResponseEntity<?> calculationMonthExerciseGoal(
            List<DailyProgress> dailyProgresses,
            HealthGoal healthGoal) {

        exerciseService.calculationHealthGoal(dailyProgresses, healthGoal);
        return ResponseEntity.ok().build();
    }

}
