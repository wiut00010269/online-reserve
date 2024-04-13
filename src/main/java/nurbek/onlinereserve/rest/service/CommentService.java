package nurbek.onlinereserve.rest.service;

// Abduraximov Nurbek  3/24/2024   5:59 PM

import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.rest.payload.req.ReqComment;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;

public interface CommentService {

    SuccessMessage writeReview(ReqComment request) throws BranchRequestException;

}
