package nurbek.onlinereserve.rest.endpoint.controller;

// Abduraximov Nurbek  3/24/2024   5:57 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.rest.endpoint.CommentEndpoint;
import nurbek.onlinereserve.rest.payload.req.branch.ReqBranchId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController implements CommentEndpoint {

    @Override
    public ResponseEntity<?> writeComment(ReqBranchId request) {
        return null;
    }

}
