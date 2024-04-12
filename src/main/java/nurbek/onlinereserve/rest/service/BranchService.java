package nurbek.onlinereserve.rest.service;

// Abduraximov Nurbek  1/11/2024   4:25 PM

import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.rest.payload.req.branch.ReqBranchId;
import nurbek.onlinereserve.rest.payload.req.branch.ReqRegisterBranch;
import nurbek.onlinereserve.rest.payload.res.ResBranch;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;

import java.util.List;

public interface BranchService {

    SuccessMessage registerBranch(ReqRegisterBranch request) throws BranchRequestException;

    List<ResBranch> getAllBranches();

    ResBranch getOneBranch(ReqBranchId request);

}
