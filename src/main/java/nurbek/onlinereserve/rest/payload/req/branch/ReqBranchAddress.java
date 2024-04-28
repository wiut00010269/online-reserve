package nurbek.onlinereserve.rest.payload.req.branch;

// Abduraximov Nurbek  1/12/2024   3:33 PM

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqBranchAddress {

    private String region;

    private String street;

    private String map;

}
