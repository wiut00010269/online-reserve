package nurbek.onlinereserve.config.doc;

// Abduraximov Nurbek  1/8/2024   6:48 PM

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Operation
@ApiResponse
public @interface DocMethodAuth {

    String summary() default "";

    String description() default "";

    String responseCode() default "default";

    Content[] content() default {};

}

