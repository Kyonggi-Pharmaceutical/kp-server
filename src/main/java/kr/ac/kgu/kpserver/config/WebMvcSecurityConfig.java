package kr.ac.kgu.kpserver.config;

import kr.ac.kgu.kpserver.domain.user.UserService;
import kr.ac.kgu.kpserver.handler.CustomUserHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcSecurityConfig implements WebMvcConfigurer {

    private final WebProperty webProperty;
    private final UserService userService;

    public WebMvcSecurityConfig(WebProperty webProperty, UserService userService) {
        this.webProperty = webProperty;
        this.userService = userService;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins(webProperty.getOrigin())
                .allowedMethods(
                        HttpMethod.GET.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name(),
                        HttpMethod.OPTIONS.name()
                )
                .allowedHeaders("*")
                .allowCredentials(true)
        ;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CustomUserHandlerMethodArgumentResolver(userService));
    }
}
