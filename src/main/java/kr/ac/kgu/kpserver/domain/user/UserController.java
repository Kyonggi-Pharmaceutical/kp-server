package kr.ac.kgu.kpserver.domain.user;

import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.domain.user.dto.UserSignUpRequest;
import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMyInfo(Principal principal) {
        long userId = Long.parseLong(principal.getName());
        User user = userService.findUserByIdOrNull(userId);
        if (user == null) {
            throw new KpException(KpExceptionType.NOT_FOUND_USER);
        }
        return ResponseEntity.ok().body(UserDto.from(user));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(
            @Valid @RequestBody UserSignUpRequest userSignUpRequest,
            Principal principal
    ) {
        long userId = Long.parseLong(principal.getName());
        User user = userService.findUserByIdOrNull(userId);
        if (user == null) {
            throw new KpException(KpExceptionType.NOT_FOUND_USER);
        }
        if (user.getExerciseGroup() != null) {
            throw new KpException(KpExceptionType.ALREADY_SIGN_UP);
        }

        userService.signUpUser(user, userSignUpRequest);
        return ResponseEntity.ok().build();
    }
}
