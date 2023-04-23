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
    public ResponseEntity<User> saveUserExerciseGroup(User user,
                                                      @RequestBody UserDto userDto) {
        User users = exerciseService.saveExerciseGroup(user, userDto);
        return ResponseEntity.ok().body(users);
    }
    //메소드에 따른 api 수정 아직 미완
    @Operation(summary = "사용자 운동 타입 저장 API")
    @UserAuthenticated
    @Transactional
    @GetMapping("/exerciseMain")
    public ResponseEntity<UserDto> saveUserExerciseGroup(User user) {
        return ResponseEntity.ok().body(UserDto.from(user));
    }



}