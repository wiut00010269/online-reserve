package nurbek.onlinereserve.rest.endpoint;

// Abduraximov Nurbek  1/11/2024   4:11 PM

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import nurbek.onlinereserve.base.BaseURI;
import nurbek.onlinereserve.config.doc.DocController;
import nurbek.onlinereserve.config.doc.DocMethodAuth;
import nurbek.onlinereserve.rest.payload.req.ReqRegisterBranch;
import nurbek.onlinereserve.rest.payload.res.ResBranch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@DocController(name = "Branch module", description = "Branch Section")
@RequestMapping(BaseURI.API_V1_PATH + BaseURI.BRANCH)
public interface BranchEndpoint {

    @DocMethodAuth(
            summary = "Manager can register a branch",
            responseCode = "200",
            description = "Operation success",
            content = @Content(schema = @Schema(implementation = ResBranch.class))
    )
    @PostMapping(BaseURI.REGISTER)
    ResponseEntity<?> registerBranch(@RequestBody ReqRegisterBranch request);

    @DocMethodAuth(
            summary = "Get Branch List",
            responseCode = "200",
            description = "Operation success",
            content = @Content(schema = @Schema(implementation = ResBranch.class))
    )
    @GetMapping(BaseURI.LIST)
    ResponseEntity<?> getBranchList();

}
