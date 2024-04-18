package nurbek.onlinereserve.config.doc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Operation
@ApiResponse
public @interface DocMethod {
    String summary() default "";
    String description() default "";
    String responseCode() default "default";
    Content[] content() default {};
}
