package nurbek.onlinereserve.rest.payload.req.branch;

// Abduraximov Nurbek  4/12/2024   8:00 PM

import lombok.*;
import nurbek.onlinereserve.rest.enums.BranchType;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqUpdateBranch implements Serializable {

    private Long id;

    private String name;

    private String description;

    private String additionalPhone;

    private LocalTime openAt;

    private LocalTime closeAt;

    private BranchType type;

    private ReqBranchAddress address;

    private ReqBranchCapacity capacity;

}
