package kr.ac.kgu.kpserver.handler;

import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserService;
import kr.ac.kgu.kpserver.security.UserAuthenticated;
import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class CustomUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private final UserService userService;

    public CustomUserHandlerMethodArgumentResolver(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasMethodAnnotation(UserAuthenticated.class) && parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new KpException(KpExceptionType.AUTHENTICATION_FAILED);
        }
        Long userId = (Long) authentication.getPrincipal();
        User user = userService.findUserByIdOrNull(userId);
        if (user == null) {
            throw new KpException(KpExceptionType.NOT_FOUND_USER);
        }
        return user;
    }
}
