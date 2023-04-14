package kr.ac.kgu.kpserver.domain.user;

import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.domain.user.dto.UserRequest;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @UserAuthenticated
    @GetMapping("/me")
    public ResponseEntity<UserDto> getMyInfo(User user) {
        return ResponseEntity.ok().body(UserDto.from(user));
    }

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

    @UserAuthenticated
    @PutMapping("/me")
    public ResponseEntity<UserDto> updateMyInfo(
            @Valid @RequestBody UserRequest userRequest,
            User user
    ) {
        User updatedUser = userService.updateUser(user, userRequest);
        return ResponseEntity.ok(UserDto.from(updatedUser));
    }

    @UserAuthenticated
    @DeleteMapping("/me")
    public ResponseEntity<Void> withdrawal(User user) {
        userService.deleteUser(user);
        return ResponseEntity.ok().build();
    }
}
