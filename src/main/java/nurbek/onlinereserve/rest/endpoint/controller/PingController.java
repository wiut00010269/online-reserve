package nurbek.onlinereserve.rest.endpoint.controller;

// Abduraximov Nurbek  4/28/2024   4:27 PM

import nurbek.onlinereserve.base.BaseURI;
import nurbek.onlinereserve.config.core.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BaseURI.API_V1_PATH)
public class PingController {

    @GetMapping(BaseURI.PING)
    public ResponseEntity<?> ping() {
        return GenericResponse.success(200, "Success");
    }
}
