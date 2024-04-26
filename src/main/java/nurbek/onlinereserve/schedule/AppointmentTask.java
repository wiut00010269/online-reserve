package nurbek.onlinereserve.schedule;

// Abduraximov Nurbek 24/04/2024   17:39

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.rest.entity.Appointment;
import nurbek.onlinereserve.rest.entity.branch.ActiveCapacity;
import nurbek.onlinereserve.rest.entity.branch.Branch;
import nurbek.onlinereserve.rest.enums.AppointmentStatus;
import nurbek.onlinereserve.rest.repo.ActiveCapacityRepo;
import nurbek.onlinereserve.rest.repo.AppointmentRepository;
import nurbek.onlinereserve.rest.repo.BranchRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("appointmentTaskSchedule")
@RequiredArgsConstructor
public class AppointmentTask {

    private final AppointmentRepository appointmentRepository;
    private final BranchRepository branchRepository;
    private final ActiveCapacityRepo activeCapacityRepo;

    @Scheduled(cron = "0 */10 * * * *")
    public void finishBookingRestaurants() {

        List<Appointment> allByStatus = appointmentRepository.findAllByStatus(AppointmentStatus.BOOKED);

        for (Appointment appointment : allByStatus) {
            if (AppointmentStatus.BOOKED.equals(appointment.getStatus())) {

                Optional<Branch> optionalBranch = branchRepository.findByUuid(UUID.fromString(appointment.getBranchId()));
                if (optionalBranch.isEmpty()) {
                    return;
                }
                Branch branch = optionalBranch.get();

                ActiveCapacity activeCapacity = branch.getActiveCapacity();

                switch (appointment.getTableType()) {
                    case TABLE2:
                        activeCapacity.setTable2(activeCapacity.getTable2() + 1);
                        activeCapacityRepo.save(activeCapacity);
                        break;
                    case TABLE4:
                        activeCapacity.setTable4(activeCapacity.getTable4() + 1);
                        activeCapacityRepo.save(activeCapacity);
                        break;
                    case TABLE8:
                        activeCapacity.setTable8(activeCapacity.getTable8() + 1);
                        activeCapacityRepo.save(activeCapacity);
                        break;
                    case TABLE12:
                        activeCapacity.setTable12(activeCapacity.getTable12() + 1);
                        activeCapacityRepo.save(activeCapacity);
                        break;
                    case TABLE20:
                        activeCapacity.setTable20(activeCapacity.getTable20() + 1);
                        activeCapacityRepo.save(activeCapacity);
                        break;
                }

                appointment.setStatus(AppointmentStatus.FINISHED);
                appointmentRepository.save(appointment);
            }
        }
    }


}
