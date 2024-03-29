package nurbek.onlinereserve.rest.payload.res;

// Abduraximov Nurbek  1/11/2024   4:15 PM

import lombok.*;
import nurbek.onlinereserve.rest.entity.branch.BranchAddress;

import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResBranch {

    private String name;

    private String description;

    private LocalTime openAt;

    private LocalTime closeAt;

    private String grade;

    private BranchAddress address;

}
