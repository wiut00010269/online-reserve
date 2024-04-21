package nurbek.onlinereserve.rest.endpoint.controller;

// Abduraximov Nurbek  1/11/2024   4:24 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.core.GenericResponse;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.rest.endpoint.BranchEndpoint;
import nurbek.onlinereserve.rest.payload.req.ReqCount;
import nurbek.onlinereserve.rest.payload.req.branch.ReqBranchId;
import nurbek.onlinereserve.rest.payload.req.branch.ReqRate;
import nurbek.onlinereserve.rest.payload.req.branch.ReqRegisterBranch;
import nurbek.onlinereserve.rest.payload.req.branch.ReqUpdateBranch;
import nurbek.onlinereserve.rest.payload.res.branch.ResBranch;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import nurbek.onlinereserve.rest.payload.res.branch.ResMyBranch;
import nurbek.onlinereserve.rest.service.BranchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BranchController implements BranchEndpoint {

    private final BranchService service;

    ///*------------------------------ Admin Panel -----------------------------------*///////

    @Override
    public ResponseEntity<?> registerBranch(ReqRegisterBranch request) {
        try {
            SuccessMessage resBranch = service.registerBranch(request);
            return GenericResponse.success(200, "Success", resBranch);
        } catch (BranchRequestException e) {
            return GenericResponse.error(400, e.getMessage());
        } catch (Throwable th) {
            return GenericResponse.error(401, th.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> updateBranch(ReqUpdateBranch request) {
        try {
            SuccessMessage resBranch = service.updateBranch(request);
            return GenericResponse.success(200, "Success", resBranch);
        } catch (Throwable th) {
            return GenericResponse.error(401, th.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> myBranches() {
        try {
            List<ResMyBranch> myBranchList = service.myBranchList();
            return GenericResponse.success(200, "Success", myBranchList);
        } catch (Throwable th) {
            return GenericResponse.error(401, th.getMessage());
        }
    }


    ///*------------------------------- User Side -------------------------------------*///////

    // TODO: 4/21/2024 search, sort {by: MOST | LEAST | TOP RATED | LOW RATED }, filter {by: REGION}  and pagination
    @Override
    public ResponseEntity<?> getBranchList() {
        List<ResBranch> branchList = service.getAllBranches();
        return GenericResponse.success(200, "Success", branchList);
    }

    @Override
    public ResponseEntity<?> getBranchOne(ReqBranchId request) throws BranchRequestException {
        ResBranch oneBranch = service.getOneBranch(request);
        return GenericResponse.success(200, "Success", oneBranch);
    }

    @Override
    public ResponseEntity<?> rateBranch(ReqRate request) throws BranchRequestException {
        SuccessMessage msg = service.rateBranch(request);
        return GenericResponse.success(200, "Success", msg);
    }

    @Override
    public ResponseEntity<?> getNewRestaurants(ReqCount request) throws BranchRequestException {
        try {
            List<ResBranch> resultList = service.getNewestRestaurants(request);
            return GenericResponse.success(200, "Success", resultList);
        } catch (Throwable th) {
            return GenericResponse.error(401, th.getMessage());
        }
    }

}
