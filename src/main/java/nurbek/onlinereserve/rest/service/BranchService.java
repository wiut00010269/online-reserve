package nurbek.onlinereserve.rest.service;

// Abduraximov Nurbek  1/11/2024   4:25 PM

import nurbek.onlinereserve.rest.payload.req.ReqRegisterBranch;
import nurbek.onlinereserve.rest.payload.res.ResBranch;

import java.util.List;

public interface BranchService {

    ResBranch registerBranch(ReqRegisterBranch request);

    List<ResBranch> getAllBranches();

}
