package nurbek.onlinereserve.rest.payload.res;

// Abduraximov Nurbek 04/04/2024   13:16

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResFormattedTime implements Serializable {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
