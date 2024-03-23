package nurbek.onlinereserve.rest.service;

// Abduraximov Nurbek  1/9/2024   11:49 AM

import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.rest.payload.req.appointment.ReqAppointment;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;

public interface AppointmentService {

    SuccessMessage makeAppointment(ReqAppointment request) throws BranchRequestException;

}
