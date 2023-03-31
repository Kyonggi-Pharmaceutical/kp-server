package kr.ac.kgu.kpserver.config;

import lombok.Data;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("oauth2")
public class OAuth2Property {

    private String jwtKey = RandomString.make(64);

    private Google google;

    @Data
    public static class Google {

        private String clientId;
        private String clientSecret;

    }

}
