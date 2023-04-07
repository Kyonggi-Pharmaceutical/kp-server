package kr.ac.kgu.kpserver.config;

import io.swagger.v3.oas.models.parameters.HeaderParameter;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenApiCustomiser openApiCustomiser() {
        return openApi ->
                openApi.getPaths().values().stream()
                        .flatMap(pathItem -> pathItem.readOperations().stream())
                        .forEach(
                                operation ->
                                        operation.addParametersItem(
                                                new HeaderParameter()
                                                        .name("x-dummy-user-id").description("더미 인증 용 유저 ID")));
    }

}
