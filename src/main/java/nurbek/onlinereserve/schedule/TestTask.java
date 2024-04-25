//package nurbek.onlinereserve.schedule;
//
//// Abduraximov Nurbek  3/16/2024   2:47 PM
//
//import lombok.RequiredArgsConstructor;
//import nurbek.onlinereserve.rest.entity.branch.Branch;
//import nurbek.onlinereserve.rest.enums.BranchStatus;
//import nurbek.onlinereserve.rest.repo.BranchRepository;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class TestTask {
//
//    private final BranchRepository branchRepository;
//
////    @Scheduled(cron = "0 */10 * * * *")
////    public void changeBranchInfo() {
////
////        System.out.println("Eyy nima gap!");
////        List<Branch> all = branchRepository.findAll();
////        for (Branch branch : all) {
////            branch.setStatus(BranchStatus.ACTIVE);
////            branchRepository.save(branch);
////        }
////    }
//
//}
