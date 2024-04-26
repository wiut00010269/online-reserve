package nurbek.onlinereserve.schedule;

// Abduraximov Nurbek 26/04/2024   16:02

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.rest.repo.ActiveCapacityRepo;
import nurbek.onlinereserve.rest.repo.BranchOriginalCapacityRepo;
import nurbek.onlinereserve.rest.repo.BranchRepository;
import org.springframework.stereotype.Component;

@Component("capacityTaskSchedule")
@RequiredArgsConstructor
public class CapacityTask {

    private final BranchRepository branchRepository;
    private final ActiveCapacityRepo activeCapacityRepo;
    private final BranchOriginalCapacityRepo originalCapacityRepo;


}
