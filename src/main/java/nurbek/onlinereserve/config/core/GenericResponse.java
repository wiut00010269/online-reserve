package nurbek.onlinereserve.config.core;

// Abduraximov Nurbek  1/9/2024   11:52 AM

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class GenericResponse<T> {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("result")
    private GenericResult<T> result;

    public GenericResponse(Boolean success, Integer code) {
        this.success = success;
        this.result = new GenericResult<>(
                code,
                this.success ? "Success" : "Unknown Error",
                GlobalVar.getRequestId(),
                null
        );
    }

    public GenericResponse(Boolean success, Integer code, String message) {
        this.success = success;
        this.result = new GenericResult<>(
                code,
                message,
                GlobalVar.getRequestId(),
                null
        );
    }

    public GenericResponse(Boolean success, Integer code, String message, T data) {
        this.success = success;
        this.result = new GenericResult<>(
                code,
                message,
                GlobalVar.getRequestId(),
                data
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> success(Integer code) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.TRUE, code)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> success(Integer code, String message) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.TRUE, code, message)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> success(Integer code, String message, T data) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.TRUE, code, message, data)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> error(Integer code) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.FALSE, code)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> error(Integer code, String message) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.FALSE, code, message)
        );
    }

    public static <T> ResponseEntity<GenericResponse<T>> error(Integer code, String message, T data) {
        return ResponseEntity.ok(
                new GenericResponse<>(Boolean.FALSE, code, message, data)
        );
    }
}
