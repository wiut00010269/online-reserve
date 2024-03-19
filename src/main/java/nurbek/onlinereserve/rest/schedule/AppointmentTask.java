package nurbek.onlinereserve.rest.schedule;

// Abduraximov Nurbek 19/03/2024   14:33

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.rest.entity.branch.Branch;
import nurbek.onlinereserve.rest.enums.BranchStatus;
import nurbek.onlinereserve.rest.repo.BranchRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AppointmentTask {

    private final BranchRepository branchRepository;

    @Scheduled(cron = "0 6 15 * * ?")
//    @SchedulerLock(name = "AutoPayTask.autoPay", lockAtLeastFor = "PT5M", lockAtMostFor = "PT15M")
    public void statusChange() throws BranchRequestException {

        System.out.println("Eee nima gap!!");

        Optional<Branch> optionalBranch = branchRepository.findById(1L);
        if (optionalBranch.isEmpty()) {
            throw new BranchRequestException("Branch not found");
        }
        Branch branch = optionalBranch.get();

        branch.setStatus(BranchStatus.ACTIVE);
        branchRepository.save(branch);
    }

}
