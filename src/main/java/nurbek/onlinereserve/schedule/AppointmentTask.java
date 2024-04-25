package nurbek.onlinereserve.schedule;

// Abduraximov Nurbek 24/04/2024   17:39

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.rest.entity.Appointment;
import nurbek.onlinereserve.rest.enums.AppointmentStatus;
import nurbek.onlinereserve.rest.repo.AppointmentRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("appointmentTaskSchedule")
@RequiredArgsConstructor
public class AppointmentTask {

    private final AppointmentRepository appointmentRepository;

    @Scheduled(cron = "0 */10 * * * *")
    public void finishBookingRestaurants() {

        List<Appointment> allByStatus = appointmentRepository.findAllByStatus(AppointmentStatus.BOOKED);

        for (Appointment appointment : allByStatus) {
            if (AppointmentStatus.BOOKED.equals(appointment.getStatus())) {
                appointment.setStatus(AppointmentStatus.FINISHED);
                appointmentRepository.save(appointment);
            }
        }
    }


}
