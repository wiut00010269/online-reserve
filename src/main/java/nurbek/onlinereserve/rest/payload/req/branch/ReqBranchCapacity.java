package nurbek.onlinereserve.rest.payload.req.branch;

// Abduraximov Nurbek  3/16/2024   12:41 PM

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqBranchCapacity {

    private Integer table2;

    private Integer table4;

    private Integer table8;

    private Integer table12;

    private Integer table20;

    private Integer specialRoom;

    private Integer hall;

}
