package nurbek.onlinereserve.rest.payload.req.branch;

// Abduraximov Nurbek  4/12/2024   8:00 PM

import lombok.*;
import nurbek.onlinereserve.rest.enums.BranchStatus;

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

    private String slug;

    private String imgUrl;

    private LocalTime openAt;

    private LocalTime closeAt;

    private BranchStatus status;

    private ReqBranchAddress address;

    private ReqBranchCapacity capacity;

}
