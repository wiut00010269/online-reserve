package nurbek.onlinereserve.rest.payload.req.branch;

// Abduraximov Nurbek  1/11/2024   4:29 PM

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqRegisterBranch {

    private String name;

    private String description;

    private String slug;

    private LocalTime openAt;

    private LocalTime closeAt;

    private String imgUrl;

    private ReqBranchAddress address;

    private ReqBranchCapacity capacity;

}
