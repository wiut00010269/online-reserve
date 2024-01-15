package nurbek.onlinereserve.config.core;

// Abduraximov Nurbek  1/9/2024   11:53 AM

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericResult<T> {

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("audit")
    private String audit;

    @JsonProperty("data")
    private T data;
}
