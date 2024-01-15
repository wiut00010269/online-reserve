package nurbek.onlinereserve.rest.service.impl;

// Abduraximov Nurbek  1/11/2024   4:26 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.rest.entity.Branch;
import nurbek.onlinereserve.rest.entity.BranchAddress;
import nurbek.onlinereserve.rest.enums.BranchStatus;
import nurbek.onlinereserve.rest.payload.req.ReqRegisterBranch;
import nurbek.onlinereserve.rest.payload.res.ResBranch;
import nurbek.onlinereserve.rest.repo.BranchAddressRepository;
import nurbek.onlinereserve.rest.repo.BranchRepository;
import nurbek.onlinereserve.rest.service.BranchService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository repository;
    private final BranchAddressRepository addressRepository;

    @Override
    public ResBranch registerBranch(ReqRegisterBranch request) {

        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setRegion(request.getReqBranchAddress().getRegion());
        branchAddress.setDistrict(request.getReqBranchAddress().getDistrict());
        branchAddress.setStreet(request.getReqBranchAddress().getStreet());
        branchAddress.setHomeNumber(request.getReqBranchAddress().getHomeNumber());
        branchAddress.setTarget(request.getReqBranchAddress().getTarget());
        branchAddress.setAdditionalInfo(request.getReqBranchAddress().getAdditionalInfo());
        addressRepository.save(branchAddress);

        Branch branch = new Branch();
        branch.setName(request.getName());
        branch.setDescription(request.getDescription());
        branch.setManager1Id(request.getManager1Id());
        branch.setManager2Id(request.getManager2Id());
        branch.setStatus(BranchStatus.INACTIVE);
        branch.setOpenAt(request.getOpenAt());
        branch.setCloseAt(request.getCloseAt());
        branch.setAddress(branchAddress);

        repository.save(branch);

        return null;
    }

}
