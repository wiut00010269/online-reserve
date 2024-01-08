package nurbek.onlinereserve.rest.endpoint;

// Abduraximov Nurbek  1/8/2024   6:27 PM

import nurbek.onlinereserve.base.BaseURI;
import nurbek.onlinereserve.config.doc.DocController;
import org.springframework.web.bind.annotation.RequestMapping;

@DocController(name = "Appointment module", description = "Appointment Section")
@RequestMapping(BaseURI.API_V1_PATH + BaseURI.APPOINTMENT)
public interface AppointmentEndpoint {


}
