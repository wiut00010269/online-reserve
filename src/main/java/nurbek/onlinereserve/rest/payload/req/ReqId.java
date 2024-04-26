package nurbek.onlinereserve.rest.payload.req;

// Abduraximov Nurbek 26/04/2024   11:00

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqId implements Serializable {

    private Long id;

}
