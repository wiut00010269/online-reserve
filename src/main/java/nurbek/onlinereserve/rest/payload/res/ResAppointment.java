package nurbek.onlinereserve.rest.payload.res;

// Abduraximov Nurbek  1/9/2024   10:58 AM

import lombok.*;
import nurbek.onlinereserve.rest.enums.AppointmentStatus;
import nurbek.onlinereserve.rest.enums.TableType;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResAppointment implements Serializable {

    private String id;

    private String user;

    private AppointmentStatus status;

    private LocalDateTime startAt;

    private TableType tableType;

    private String restaurantName;

}
