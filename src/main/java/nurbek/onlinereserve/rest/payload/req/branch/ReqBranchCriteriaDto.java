package nurbek.onlinereserve.rest.payload.req.branch;

// Abduraximov Nurbek 26/04/2024   10:43

import lombok.*;
import nurbek.onlinereserve.rest.payload.req.ReqPaging;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqBranchCriteriaDto implements Serializable {



    private ReqPaging paging;

}
