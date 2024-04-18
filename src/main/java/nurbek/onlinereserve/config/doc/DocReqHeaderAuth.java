package nurbek.onlinereserve.config.doc;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@DocReqHeaderLang
@Parameter(in = ParameterIn.HEADER, name = "X-Auth-Token")
public @interface DocReqHeaderAuth {
}
