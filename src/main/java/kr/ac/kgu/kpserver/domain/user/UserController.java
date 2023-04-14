package kr.ac.kgu.kpserver.domain.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.domain.user.dto.UserRequest;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "유저 API")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "나의 정보 조회 API")
    @UserAuthenticated
    @GetMapping("/me")
    public ResponseEntity<UserDto> getMyInfo(User user) {
        return ResponseEntity.ok().body(UserDto.from(user));
    }

    @Operation(summary = "유저 회원가입 API")
    @UserAuthenticated
    @PostMapping("/sign-up")
    public ResponseEntity<UserDto> signUp(
            @Valid @RequestBody UserRequest userRequest,
            User user
    ) {
        if (user.getExerciseGroup() != null) {
            throw new KpException(KpExceptionType.ALREADY_SIGN_UP);
        }
        User signUpUser = userService.updateUser(user, userRequest);
        return ResponseEntity.ok(UserDto.from(signUpUser));
    }

    @Operation(summary = "유저 정보 업데이트 API")
    @UserAuthenticated
    @PutMapping("/me")
    public ResponseEntity<UserDto> updateMyInfo(
            @Valid @RequestBody UserRequest userRequest,
            User user
    ) {
        User updatedUser = userService.updateUser(user, userRequest);
        return ResponseEntity.ok(UserDto.from(updatedUser));
    }

    @Operation(summary = "회원탈퇴 API")
    @UserAuthenticated
    @DeleteMapping("/me")
    public ResponseEntity<Void> withdrawal(User user) {
        userService.deleteUser(user);
        return ResponseEntity.ok().build();
    }
}
