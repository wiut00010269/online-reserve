package nurbek.onlinereserve.config.doc;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ApiResponses(value = {
        @ApiResponse(responseCode = "401", description = "Not Authorization"),
        @ApiResponse(responseCode = "500", description = "Internal server error"),
})
public @interface DocResError {
}
