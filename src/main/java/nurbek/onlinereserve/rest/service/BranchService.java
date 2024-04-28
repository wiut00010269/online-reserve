package nurbek.onlinereserve.rest.service;

// Abduraximov Nurbek  1/11/2024   4:25 PM

import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.config.exception.CustomException;
import nurbek.onlinereserve.rest.payload.req.ReqCount;
import nurbek.onlinereserve.rest.payload.req.ReqId;
import nurbek.onlinereserve.rest.payload.req.ReqUUID;
import nurbek.onlinereserve.rest.payload.req.branch.ReqBranchId;
import nurbek.onlinereserve.rest.payload.req.branch.ReqRate;
import nurbek.onlinereserve.rest.payload.req.branch.ReqRegisterBranch;
import nurbek.onlinereserve.rest.payload.req.branch.ReqUpdateBranch;
import nurbek.onlinereserve.rest.payload.res.branch.ResBranch;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import nurbek.onlinereserve.rest.payload.res.branch.ResMyBranch;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BranchService {

    //**=========================== Admin Panel ================================**//

    SuccessMessage registerBranch(ReqRegisterBranch request) throws BranchRequestException, CustomException;

    SuccessMessage updateBranch(ReqUpdateBranch request) throws BranchRequestException;

    List<ResMyBranch> myBranchList() throws CustomException;

    SuccessMessage deleteMyBranch(ReqId request) throws BranchRequestException;



    //**=========================== User Side ================================**//

    List<ResBranch> getAllBranches();

    ResBranch getOneBranch(ReqUUID request) throws BranchRequestException;

    SuccessMessage rateBranch(ReqRate request) throws BranchRequestException;

    List<ResBranch> getNewestRestaurants(ReqCount request) throws BranchRequestException;

    List<ResBranch> getTopBookedRestaurants(ReqCount request) throws BranchRequestException;

    String uploadRestaurantFile(MultipartFile file);

}
