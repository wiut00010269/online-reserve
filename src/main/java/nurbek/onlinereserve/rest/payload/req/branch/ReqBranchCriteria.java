package nurbek.onlinereserve.rest.payload.req.branch;

// Abduraximov Nurbek  4/28/2024   6:36 PM

import lombok.*;
import nurbek.onlinereserve.rest.payload.req.ReqPaging;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqBranchCriteria implements Serializable {

    private String name;

    private String region;

    private ReqPaging paging;

}
