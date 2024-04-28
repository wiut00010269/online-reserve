package nurbek.onlinereserve.rest.endpoint.controller;

// Abduraximov Nurbek  3/24/2024   5:57 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.core.GenericResponse;
import nurbek.onlinereserve.rest.endpoint.CommentEndpoint;
import nurbek.onlinereserve.rest.payload.req.ReqComment;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import nurbek.onlinereserve.rest.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController implements CommentEndpoint {

    private final CommentService service;

    @Override
    public ResponseEntity<?> writeComment(ReqComment request) {
        try {
            SuccessMessage result = service.writeReview(request);
            return GenericResponse.success(200, "Success", result);
        } catch (Throwable th) {
            return GenericResponse.error(401, th.getMessage());
        }
    }

}
