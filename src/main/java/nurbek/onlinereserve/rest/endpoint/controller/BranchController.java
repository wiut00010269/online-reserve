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
    public ResponseEntity<?> registerBranch(ReqRegisterBranch request) {
        ResBranch resBranch = service.registerBranch(request);
        return GenericResponse.success(200, "Success", resBranch);
    }

    @Override
    public ResponseEntity<?> getBranchList() {
        List<ResBranch> branchList = service.getAllBranches();
        return null;
    }
}
