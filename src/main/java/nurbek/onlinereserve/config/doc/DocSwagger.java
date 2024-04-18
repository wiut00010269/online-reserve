package nurbek.onlinereserve.config.doc;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@DocReqHeaderLang
@DocResError
public @interface DocSwagger {
}
