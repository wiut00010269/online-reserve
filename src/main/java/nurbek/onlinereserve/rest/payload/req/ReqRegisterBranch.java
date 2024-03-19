package nurbek.onlinereserve.rest.payload.req;

// Abduraximov Nurbek  1/11/2024   4:29 PM

import lombok.*;
import nurbek.onlinereserve.rest.enums.BranchType;

import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqRegisterBranch {

    private String name;

    private String description;

    private String manager1Id;

    private String manager2Id;

    private LocalTime openAt;

    private LocalTime closeAt;

    private BranchType type;

    private ReqBranchAddress reqBranchAddress;

    private ReqBranchCapacity reqCapacity;

}
