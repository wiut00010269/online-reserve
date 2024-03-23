package nurbek.onlinereserve.rest.payload.req.appointment;

// Abduraximov Nurbek  3/23/2024   10:54 AM

import lombok.*;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqAppointment implements Serializable {

    private String branchUuid;

    private Long tableType;

    private LocalDateTime startTime;
    private Duration duration;

}
