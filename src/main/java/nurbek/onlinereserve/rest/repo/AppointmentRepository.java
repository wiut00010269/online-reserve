package nurbek.onlinereserve.rest.repo;

// Abduraximov Nurbek  3/23/2024   10:49 PM

import nurbek.onlinereserve.rest.entity.Appointment;
import nurbek.onlinereserve.rest.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByUuid(UUID uuid);

    Optional<Appointment> findTopByUserIdAndBranchIdAndStatusOrderByCreatedAt(String userId, String branchId, AppointmentStatus status);

}
