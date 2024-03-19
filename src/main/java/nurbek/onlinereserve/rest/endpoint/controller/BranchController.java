package nurbek.onlinereserve.rest.endpoint.controller;

// Abduraximov Nurbek  1/11/2024   4:24 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.core.GenericResponse;
import nurbek.onlinereserve.rest.endpoint.BranchEndpoint;
import nurbek.onlinereserve.rest.payload.req.ReqRegisterBranch;
import nurbek.onlinereserve.rest.payload.res.ResBranch;
import nurbek.onlinereserve.rest.service.BranchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BranchController implements BranchEndpoint {

    private final BranchService service;

    @Override
    public ResponseEntity<?> registerBranch(ReqRegisterBranch request) throws BadRequestException {
        try {
            SuccessMessage resBranch = service.registerBranch(request);
            return GenericResponse.success(200, "Success", resBranch);
        } catch (BadRequestException e) {
            return GenericResponse.error(400, e.getMessage());
        }

    }

    @Override
    public ResponseEntity<?> getBranchList() {
        List<ResBranch> branchList = service.getAllBranches();
        return GenericResponse.success(200, "Success", branchList);
    }

    @Override
    public ResponseEntity<?> getBranchOne(ReqBranchId request) {
        ResBranch oneBranch = service.getOneBranch(request);
        return GenericResponse.success(200, "Success", oneBranch);
    }
}
