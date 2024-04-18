package nurbek.onlinereserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
public class OnlineReserveApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineReserveApplication.class, args);
    }

}
