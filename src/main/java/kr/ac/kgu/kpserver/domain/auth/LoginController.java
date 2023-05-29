package kr.ac.kgu.kpserver.domain.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.ac.kgu.kpserver.domain.user.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

@Tag(name = "로그인 API")
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Google OAuth2.0 로그인 API")
    @PostMapping("/oauth/google")
    public ResponseEntity<?> loginWithGoogleOAuth2(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        String authToken = userService.loginWithOAuth2Google(loginRequest.getIdToken());
        final ResponseCookie cookie = ResponseCookie.from("AUTH-TOKEN", authToken)
                .httpOnly(true)
                .maxAge(7 * 24 * 3600)
                .path("/")
                .secure(false)
                .build();
        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/oauth/google")
    public ResponseEntity<Void> logoutWithGoogleOAuth2(HttpServletRequest request, HttpServletResponse response) {
        final ResponseCookie cookie = ResponseCookie.from("AUTH-TOKEN", "")
                .httpOnly(true)
                .maxAge(0)
                .path("/")
                .secure(false)
                .build();
        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return ResponseEntity.ok().build();
    }
}
