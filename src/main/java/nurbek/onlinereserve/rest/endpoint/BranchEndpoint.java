package nurbek.onlinereserve.rest.endpoint;

// Abduraximov Nurbek  1/11/2024   4:11 PM

import nurbek.onlinereserve.base.BaseURI;
import nurbek.onlinereserve.rest.payload.req.ReqBranchId;
import nurbek.onlinereserve.rest.payload.req.ReqRegisterBranch;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(BaseURI.API_V1_PATH + BaseURI.BRANCH)
public interface BranchEndpoint {

    // For Admin Panel

    @PostMapping(BaseURI.REGISTER)
    ResponseEntity<?> registerBranch(@RequestBody ReqRegisterBranch request) throws BadRequestException;

    @GetMapping(BaseURI.LIST)
    ResponseEntity<?> getBranchList();

    @GetMapping(BaseURI.GET)
    ResponseEntity<?> getBranchOne(@RequestBody ReqBranchId request);




}
