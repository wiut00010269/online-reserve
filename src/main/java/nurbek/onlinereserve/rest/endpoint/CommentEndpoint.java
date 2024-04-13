package nurbek.onlinereserve.rest.endpoint;

import nurbek.onlinereserve.base.BaseURI;
import nurbek.onlinereserve.rest.payload.req.ReqComment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(BaseURI.API_V1_PATH + BaseURI.COMMENT)
public interface CommentEndpoint {

    //** ============================= User Side ===========================*//

    @PostMapping(BaseURI.WRITE)
    ResponseEntity<?> writeComment(@RequestBody ReqComment request);

}
