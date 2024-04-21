package nurbek.onlinereserve.rest.payload.req;

// Abduraximov Nurbek  4/21/2024   5:08 PM

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqCount implements Serializable {

    private Integer count;

}
