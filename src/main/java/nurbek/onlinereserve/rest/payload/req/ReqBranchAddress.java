package nurbek.onlinereserve.rest.payload.req;

// Abduraximov Nurbek  1/12/2024   3:33 PM

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqBranchAddress {

    private String region;

    private String district;

    private String street;

    private Long homeNumber;

    private String target;

    private String additionalInfo;

}
