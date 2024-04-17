package nurbek.onlinereserve.rest.service;

// Abduraximov Nurbek  1/11/2024   4:25 PM

import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.config.exception.CustomException;
import nurbek.onlinereserve.rest.payload.req.branch.ReqBranchId;
import nurbek.onlinereserve.rest.payload.req.branch.ReqRate;
import nurbek.onlinereserve.rest.payload.req.branch.ReqRegisterBranch;
import nurbek.onlinereserve.rest.payload.req.branch.ReqUpdateBranch;
import nurbek.onlinereserve.rest.payload.res.branch.ResBranch;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import nurbek.onlinereserve.rest.payload.res.branch.ResMyBranch;

import java.util.List;

public interface BranchService {

    //**=========================== Admin Panel ================================**//

    SuccessMessage registerBranch(ReqRegisterBranch request) throws BranchRequestException, CustomException;

    SuccessMessage updateBranch(ReqUpdateBranch request) throws BranchRequestException;

    List<ResMyBranch> myBranchList() throws CustomException;



    //**=========================== User Side ================================**//

    List<ResBranch> getAllBranches();

    ResBranch getOneBranch(ReqBranchId request) throws BranchRequestException;

    SuccessMessage rateBranch(ReqRate request) throws BranchRequestException;

}
