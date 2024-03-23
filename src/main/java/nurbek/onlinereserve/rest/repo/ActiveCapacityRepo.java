package nurbek.onlinereserve.rest.repo;

// Abduraximov Nurbek  3/23/2024   11:21 AM

import nurbek.onlinereserve.rest.entity.branch.ActiveCapacity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveCapacityRepo extends JpaRepository<ActiveCapacity, Long> {
}
