package kr.ac.kgu.kpserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("web")
public class WebProperty {

    private String origin;
}
