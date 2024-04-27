package nurbek.onlinereserve.rest.endpoint;

// Abduraximov Nurbek  1/11/2024   4:11 PM

import io.swagger.v3.oas.annotations.tags.Tag;
import nurbek.onlinereserve.base.BaseURI;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.rest.payload.req.ReqCount;
import nurbek.onlinereserve.rest.payload.req.ReqId;
import nurbek.onlinereserve.rest.payload.req.branch.ReqBranchId;
import nurbek.onlinereserve.rest.payload.req.branch.ReqRate;
import nurbek.onlinereserve.rest.payload.req.branch.ReqRegisterBranch;
import nurbek.onlinereserve.rest.payload.req.branch.ReqUpdateBranch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(BaseURI.API_V1_PATH + BaseURI.BRANCH)
public interface BranchEndpoint {

    // For Admin Panel

    @PostMapping(BaseURI.ADD)
    ResponseEntity<?> registerBranch(@RequestBody ReqRegisterBranch request);

    @PostMapping(BaseURI.UPLOAD + BaseURI.FILE)
    ResponseEntity<?> uploadBranchFile(@RequestParam(value = "file") MultipartFile file);

    @PostMapping(BaseURI.UPDATE)
    ResponseEntity<?> updateBranch(@RequestBody ReqUpdateBranch request);

    // TODO: 4/23/2024 change API way
    @GetMapping(BaseURI.MY + BaseURI.BRANCH + BaseURI.LIST)
    ResponseEntity<?> myBranches();

    @PostMapping(BaseURI.DELETE)
    ResponseEntity<?> deleteBranch(@RequestBody ReqId request);


    // For User side

    @Tag(name = "get", description = "GET methods of Employee APIs")
    @GetMapping(BaseURI.LIST)
    ResponseEntity<?> getBranchList();

    @PostMapping(BaseURI.GET + BaseURI.ONE)
    ResponseEntity<?> getBranchOne(@RequestBody ReqBranchId request) throws BranchRequestException;

    @PostMapping(BaseURI.RATE)
    ResponseEntity<?> rateBranch(@RequestBody ReqRate request) throws BranchRequestException;

    @PostMapping(BaseURI.GET + BaseURI.NEWEST)
    ResponseEntity<?> getNewRestaurants(@RequestBody ReqCount request) throws BranchRequestException;

    @PostMapping(BaseURI.GET + BaseURI.TOP + BaseURI.BOOKED + BaseURI.LIST)
    ResponseEntity<?> getTopBookedRestaurants(@RequestBody ReqCount request) throws BranchRequestException;

}
