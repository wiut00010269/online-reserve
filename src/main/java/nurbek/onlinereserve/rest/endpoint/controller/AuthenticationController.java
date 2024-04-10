package nurbek.onlinereserve.rest.endpoint.controller;

// Abduraximov Nurbek  4/10/2024   9:37 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.base.BaseURI;
import nurbek.onlinereserve.config.security.JwtUtils;
import nurbek.onlinereserve.rest.payload.req.auth.ReqAuthentication;
import nurbek.onlinereserve.rest.service.impl.UserProfileServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API_V1_PATH + BaseURI.AUTH)
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserProfileServiceImpl userProfileService;
    private final JwtUtils jwtUtils;

    @PostMapping(BaseURI.AUTHENTICATE)
    public ResponseEntity<String> authenticate (
            @RequestBody ReqAuthentication request
    ) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final UserDetails user = userProfileService.loadUserByUsername(request.getEmail());
        if (user != null) {
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("Some error occurred");
    }

}
