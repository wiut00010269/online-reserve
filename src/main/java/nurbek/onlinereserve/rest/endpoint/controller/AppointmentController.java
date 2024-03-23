package nurbek.onlinereserve.rest.endpoint.controller;

// Abduraximov Nurbek  1/8/2024   5:41 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.core.GenericResponse;
import nurbek.onlinereserve.config.exception.AppointmentRequestException;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.rest.endpoint.AppointmentEndpoint;
import nurbek.onlinereserve.rest.entity.branch.Branch;
import nurbek.onlinereserve.rest.payload.req.ReqUUID;
import nurbek.onlinereserve.rest.payload.req.appointment.ReqAppointment;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import nurbek.onlinereserve.rest.repo.BranchRepository;
import nurbek.onlinereserve.rest.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AppointmentController implements AppointmentEndpoint {

    private final AppointmentService service;

    @Override
    public ResponseEntity<?> makeAppointment(ReqAppointment request) {
        try {
            SuccessMessage result = service.makeAppointment(request);
            return GenericResponse.success(200, "Success", result);
        } catch (BranchRequestException e) {
            return GenericResponse.error(400, e.getMessage());
        } catch (Throwable th) {
            return GenericResponse.error(401, th.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> cancelAppointment(ReqUUID reqUUID) {
        try {
            SuccessMessage result = service.cancelAppointment(reqUUID);
            return GenericResponse.success(200, "Success", result);
        } catch (AppointmentRequestException e) {
            return GenericResponse.error(400, e.getMessage());
        } catch (Throwable th) {
            return GenericResponse.error(401, th.getMessage());
        }
    }


}
