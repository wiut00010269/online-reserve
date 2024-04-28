package nurbek.onlinereserve.rest.endpoint.controller;

// Abduraximov Nurbek 02/04/2024   12:36

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.base.BaseURI;
import nurbek.onlinereserve.config.core.GenericResponse;
import nurbek.onlinereserve.config.exception.CustomException;
import nurbek.onlinereserve.rest.payload.req.ReqAddUser;
import nurbek.onlinereserve.rest.payload.res.ResUserMe;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import nurbek.onlinereserve.rest.service.impl.UserProfileServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.USER)
public class UserProfileController {

    private final UserProfileServiceImpl userProfileService;

    @GetMapping(BaseURI.ME)
    public ResponseEntity<?> infoMe() {
        try {
            ResUserMe resUser = userProfileService.infoMe();
            return GenericResponse.success(200, "Success", resUser);
        } catch (CustomException e) {
            return GenericResponse.error(400, e.getMessage());
        } catch (Throwable th) {
            return GenericResponse.error(401, th.getMessage());
        }
    }

    @GetMapping(BaseURI.ADD)
    public ResponseEntity<?> addStaffs(@RequestBody ReqAddUser request) {
        try {
            SuccessMessage msg = userProfileService.addStaff(request);
            return GenericResponse.success(200, "Success", msg);
        } catch (Throwable th) {
            return GenericResponse.error(401, th.getMessage());
        }
    }



}
