package nurbek.onlinereserve.rest.payload.req;

// Abduraximov Nurbek  3/23/2024   10:58 PM

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqUUID implements Serializable {

    private UUID uuid;

}
