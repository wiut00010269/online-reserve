package nurbek.onlinereserve.rest.service.impl;

// Abduraximov Nurbek  1/9/2024   11:49 AM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.exception.AppointmentRequestException;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.rest.entity.Appointment;
import nurbek.onlinereserve.rest.entity.branch.ActiveCapacity;
import nurbek.onlinereserve.rest.entity.branch.Branch;
import nurbek.onlinereserve.rest.payload.req.ReqUUID;
import nurbek.onlinereserve.rest.payload.req.appointment.ReqAppointment;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import nurbek.onlinereserve.rest.repo.ActiveCapacityRepo;
import nurbek.onlinereserve.rest.repo.AppointmentRepository;
import nurbek.onlinereserve.rest.repo.BranchRepository;
import nurbek.onlinereserve.rest.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static nurbek.onlinereserve.rest.enums.AppointmentStatus.BOOKED;
import static nurbek.onlinereserve.rest.enums.AppointmentStatus.CANCELED;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final BranchRepository branchRepository;
    private final ActiveCapacityRepo activeCapacityRepo;
    private final AppointmentRepository appointmentRepo;

    @Override
    public SuccessMessage makeAppointment(ReqAppointment request) throws BranchRequestException {

        Optional<Branch> optionalBranch = branchRepository.findByUuid(UUID.fromString(request.getBranchUuid()));
        if (optionalBranch.isEmpty()) {
            throw new BranchRequestException("Branch not found!");
        }
        Branch branch = optionalBranch.get();

        ActiveCapacity activeCapacity = branch.getActiveCapacity();
        switch (request.getTableType()) {
            case TABLE2 :
                if (activeCapacity.getTable2() > 0) {
                    activeCapacity.setTable2(activeCapacity.getTable2() - 1);
                    activeCapacityRepo.save(activeCapacity);
                }
                break;
            case TABLE4:
                if (activeCapacity.getTable4() > 0) {
                    activeCapacity.setTable4(activeCapacity.getTable4() - 1);
                    activeCapacityRepo.save(activeCapacity);
                }
                break;
            case TABLE8:
                if (activeCapacity.getTable8() > 0) {
                    activeCapacity.setTable8(activeCapacity.getTable8() - 1);
                    activeCapacityRepo.save(activeCapacity);
                }
                break;
            case TABLE12:
                if (activeCapacity.getTable12() > 0) {
                    activeCapacity.setTable12(activeCapacity.getTable12() - 1);
                    activeCapacityRepo.save(activeCapacity);
                }
                break;
            case TABLE20:
                if (activeCapacity.getTable20() > 0) {
                    activeCapacity.setTable20(activeCapacity.getTable20() - 1);
                    activeCapacityRepo.save(activeCapacity);
                }
                break;
            case SPECIAL_ROOM:
                if (activeCapacity.getSpecialRoom() > 0) {
                    activeCapacity.setSpecialRoom(activeCapacity.getSpecialRoom() - 1);
                    activeCapacityRepo.save(activeCapacity);
                }
                break;
            case HALL:
                if (activeCapacity.getHall() > 0) {
                    activeCapacity.setHall(activeCapacity.getHall() - 1);
                    activeCapacityRepo.save(activeCapacity);
                }
                break;
        }

        Appointment appointment = new Appointment();
        appointment.setUserId(null);  // TODO: 3/23/2024 user set from security
        appointment.setBranchId(branch.getUuid().toString());
        appointment.setStatus(BOOKED);
        appointment.setStartAt(request.getStartTime());
        appointment.setEndAt(request.getStartTime().plus(request.getDuration()));
        appointment.setDepositPrice(0L);  // TODO: 3/23/2024 should be available soon
        appointment.setTableType(request.getTableType());
        appointmentRepo.save(appointment);

        return new SuccessMessage("Successfully booked!");
    }

    @Override
    public SuccessMessage cancelAppointment(ReqUUID reqUUID) throws AppointmentRequestException {

        Optional<Appointment> optionalAppointment = appointmentRepo.findByUuid(reqUUID.getUuid());
        if (optionalAppointment.isEmpty()) {
            throw new AppointmentRequestException("Appointment not found!");
        }
        Appointment appointment = optionalAppointment.get();

        if (BOOKED.equals(appointment.getStatus())) {
            appointment.setStatus(CANCELED);
            appointmentRepo.save(appointment);
            return new SuccessMessage("Appointment successfully canceled!");
        }
        return new SuccessMessage("Appointment already finished or canceled!");
    }

}
