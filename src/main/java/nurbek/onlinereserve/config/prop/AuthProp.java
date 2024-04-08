package nurbek.onlinereserve.config.prop;

// Abduraximov Nurbek 02/04/2024   12:24

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "auth")
public class AuthProp {

    private List<User> users;

    @Data
    public static class User {
        private String username;
        private String password;
        private String role;
    }

}
