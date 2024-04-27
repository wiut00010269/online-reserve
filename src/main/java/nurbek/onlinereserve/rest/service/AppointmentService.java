package nurbek.onlinereserve.rest.service;

// Abduraximov Nurbek  1/9/2024   11:49 AM

import nurbek.onlinereserve.config.exception.AppointmentRequestException;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.config.exception.CustomException;
import nurbek.onlinereserve.rest.payload.req.ReqPaging;
import nurbek.onlinereserve.rest.payload.req.ReqUUID;
import nurbek.onlinereserve.rest.payload.req.appointment.ReqAppointment;
import nurbek.onlinereserve.rest.payload.res.ResAppointment;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AppointmentService {

    SuccessMessage makeAppointment(ReqAppointment request) throws BranchRequestException, CustomException;

    SuccessMessage cancelAppointment(ReqUUID reqUUID) throws AppointmentRequestException;

    SuccessMessage finishAppointment(ReqUUID reqUUID) throws AppointmentRequestException;

    Page<ResAppointment> getMyBookingList(ReqPaging request) throws CustomException;

}
