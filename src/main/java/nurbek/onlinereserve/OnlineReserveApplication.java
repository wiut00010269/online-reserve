package nurbek.onlinereserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
@EnableScheduling
@ConfigurationPropertiesScan("nurbek.onlinereserve.config.prop")
public class OnlineReserveApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineReserveApplication.class, args);

        System.out.println("STARTED!!!");
    }

}
