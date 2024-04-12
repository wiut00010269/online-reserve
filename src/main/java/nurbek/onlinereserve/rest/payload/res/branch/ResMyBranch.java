package nurbek.onlinereserve.rest.payload.res.branch;

// Abduraximov Nurbek  4/12/2024   9:38 PM

import lombok.*;
import nurbek.onlinereserve.rest.enums.BranchStatus;
import nurbek.onlinereserve.rest.payload.res.ResAddress;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResMyBranch implements Serializable {

    private Long id;

    private String name;

    private String description;

    private LocalTime openAt;

    private LocalTime closeAt;

    private BranchStatus status;

    private String grade;

    private ResAddress address;

}
