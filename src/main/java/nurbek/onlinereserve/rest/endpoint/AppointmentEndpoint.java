package nurbek.onlinereserve.rest.endpoint;

// Abduraximov Nurbek  1/8/2024   6:27 PM

import nurbek.onlinereserve.base.BaseURI;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.rest.payload.req.ReqPaging;
import nurbek.onlinereserve.rest.payload.req.ReqUUID;
import nurbek.onlinereserve.rest.payload.req.appointment.ReqAppointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(BaseURI.API_V1_PATH + BaseURI.APPOINTMENT)
public interface AppointmentEndpoint {

    //***************************************** User Side ***************************************************//

    @PostMapping()
    ResponseEntity<?> makeAppointment(@RequestBody ReqAppointment reqAppointment) throws BranchRequestException;

    @PostMapping(BaseURI.CANCEL)
    ResponseEntity<?> cancelAppointment(@RequestBody ReqUUID reqUUID) throws BranchRequestException;

    @PostMapping(BaseURI.LIST)
    ResponseEntity<?> getMyBookingList(@RequestBody ReqPaging request) throws BranchRequestException;


    //************************************ Admin Panel ****************************************************//

    @PostMapping(BaseURI.FINISH)
    ResponseEntity<?> finishAppointment(@RequestBody ReqUUID reqUUID) throws BranchRequestException;

}
