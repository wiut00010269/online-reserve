package nurbek.onlinereserve.rest.payload.req;

// Abduraximov Nurbek  3/24/2024   6:02 PM

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqComment implements Serializable {

    private String comment;

    private Double grade;

}
