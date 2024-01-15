package nurbek.onlinereserve.rest.endpoint;

// Abduraximov Nurbek  1/8/2024   6:27 PM

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import nurbek.onlinereserve.base.BaseURI;
import nurbek.onlinereserve.config.doc.DocController;
import nurbek.onlinereserve.config.doc.DocMethodAuth;
import nurbek.onlinereserve.rest.payload.res.ResAppointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@DocController(name = "Appointment module", description = "Appointment Section")
@RequestMapping(BaseURI.API_V1_PATH + BaseURI.APPOINTMENT)
public interface AppointmentEndpoint {

    @DocMethodAuth(
            summary = "User can make an appointment",
            responseCode = "200",
            description = "Operation success",
            content = @Content(schema = @Schema(implementation = ResAppointment.class))
    )
    @PostMapping()
    ResponseEntity<?> makeAppointment();

}
