package nurbek.onlinereserve.rest.payload.req.branch;

// Abduraximov Nurbek  1/11/2024   4:29 PM

import lombok.*;
import nurbek.onlinereserve.rest.enums.BranchType;
import nurbek.onlinereserve.rest.payload.req.branch.ReqBranchAddress;
import nurbek.onlinereserve.rest.payload.req.branch.ReqBranchCapacity;

import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqRegisterBranch {

    private String name;

    private String description;

    private String additionalPhone;

    private LocalTime openAt;

    private LocalTime closeAt;

    private BranchType type;

    private ReqBranchAddress address;

    private ReqBranchCapacity capacity;

}
