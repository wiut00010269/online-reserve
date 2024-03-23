package nurbek.onlinereserve.rest.repo;

// Abduraximov Nurbek  3/23/2024   10:49 PM

import nurbek.onlinereserve.rest.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
