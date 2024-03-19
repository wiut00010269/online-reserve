package nurbek.onlinereserve.rest.endpoint;

// Abduraximov Nurbek  1/8/2024   6:27 PM

import nurbek.onlinereserve.base.BaseURI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(BaseURI.API_V1_PATH + BaseURI.APPOINTMENT)
public interface AppointmentEndpoint {

    @PostMapping()
    ResponseEntity<?> makeAppointment();

}
