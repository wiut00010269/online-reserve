package nurbek.onlinereserve.rest.payload.req.branch;

// Abduraximov Nurbek 15/04/2024   18:25

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqRate implements Serializable {

    private String branchUuid;

    private double rate;

}
