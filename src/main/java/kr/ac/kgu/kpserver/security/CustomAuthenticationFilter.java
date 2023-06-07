package kr.ac.kgu.kpserver.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final JwtAuthenticator jwtAuthenticator;

    public CustomAuthenticationFilter(JwtAuthenticator jwtAuthenticator) {
        this.jwtAuthenticator = jwtAuthenticator;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie jwtCookie = cookies == null ? null : Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("AUTH-TOKEN"))
                .findFirst().orElse(null);
        Authentication authentication;
        if (jwtCookie != null && (authentication = jwtAuthenticator.verifyTokenAndGetAuthOrNull(jwtCookie.getValue())) != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
