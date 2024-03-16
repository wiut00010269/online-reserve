package nurbek.onlinereserve.rest.service;

// Abduraximov Nurbek  1/11/2024   4:25 PM

import nurbek.onlinereserve.rest.payload.req.ReqBranchId;
import nurbek.onlinereserve.rest.payload.req.ReqRegisterBranch;
import nurbek.onlinereserve.rest.payload.res.ResBranch;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface BranchService {

    SuccessMessage registerBranch(ReqRegisterBranch request) throws BadRequestException;

    List<ResBranch> getAllBranches();

    ResBranch getOneBranch(ReqBranchId request);

}
