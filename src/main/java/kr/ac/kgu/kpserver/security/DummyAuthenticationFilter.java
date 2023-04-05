package kr.ac.kgu.kpserver.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import kr.ac.kgu.kpserver.util.KpErrorResponse;
import org.apache.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
public class DummyAuthenticationFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;

    public DummyAuthenticationFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String userId = request.getHeader("x-dummy-user-id");
        if (userId != null) {
            Optional<User> user = userRepository.findById(Long.parseLong(userId));

            if (user.isEmpty()) {
                setErrorResponse(response);
                return;
            }

            SecurityContextHolder.getContext().setAuthentication(getAuthentication(user.get()));
        }
        filterChain.doFilter(request, response);
    }

    private Authentication getAuthentication(User user) {
        return new UsernamePasswordAuthenticationToken(user, "dummy", Collections.emptyList());
    }

    private void setErrorResponse(HttpServletResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpStatus.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        KpErrorResponse errorResponse = new KpErrorResponse(-1, "인증 실패");
        try {
            response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
