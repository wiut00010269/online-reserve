package nurbek.onlinereserve.rest.endpoint.controller;

// Abduraximov Nurbek  4/10/2024   9:37 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.base.BaseURI;
import nurbek.onlinereserve.config.core.GenericResponse;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.config.exception.CustomException;
import nurbek.onlinereserve.rest.payload.req.auth.ReqAuthentication;
import nurbek.onlinereserve.rest.payload.req.auth.ReqRegisterUser;
import nurbek.onlinereserve.rest.service.impl.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API_V1_PATH + BaseURI.AUTH)
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping(BaseURI.AUTHENTICATE)
    public ResponseEntity<?> authenticate (@RequestBody ReqAuthentication request) {
        try {
            return ResponseEntity.ok(service.authenticate(request));
        } catch (BranchRequestException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(BaseURI.REGISTER)
    public ResponseEntity<?> register (@RequestBody ReqRegisterUser request) {
        try {
            return ResponseEntity.ok(service.registerUser(request));
        } catch (CustomException e) {
            return GenericResponse.error(500, e.getMessage());
        }
    }

}
