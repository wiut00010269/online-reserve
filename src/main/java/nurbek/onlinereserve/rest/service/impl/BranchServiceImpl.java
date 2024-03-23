package nurbek.onlinereserve.rest.service.impl;

// Abduraximov Nurbek  1/11/2024   4:26 PM

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.rest.entity.branch.ActiveCapacity;
import nurbek.onlinereserve.rest.entity.branch.Branch;
import nurbek.onlinereserve.rest.entity.branch.BranchAddress;
import nurbek.onlinereserve.rest.entity.branch.BranchOriginalCapacity;
import nurbek.onlinereserve.rest.enums.BranchStatus;
import nurbek.onlinereserve.rest.payload.req.ReqBranchCapacity;
import nurbek.onlinereserve.rest.payload.req.ReqBranchId;
import nurbek.onlinereserve.rest.payload.req.ReqRegisterBranch;
import nurbek.onlinereserve.rest.payload.res.ResBranch;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import nurbek.onlinereserve.rest.repo.ActiveCapacityRepo;
import nurbek.onlinereserve.rest.repo.BranchAddressRepository;
import nurbek.onlinereserve.rest.repo.BranchOriginalCapacityRepo;
import nurbek.onlinereserve.rest.repo.BranchRepository;
import nurbek.onlinereserve.rest.service.BranchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository repository;
    private final BranchAddressRepository addressRepository;
    private final BranchOriginalCapacityRepo capacityRepo;
    private final ActiveCapacityRepo activeCapacityRepo;

    @Override
    public SuccessMessage registerBranch(ReqRegisterBranch request) throws BranchRequestException {

        Optional<Branch> optionalBranch = repository.findByName(request.getName());
        if (optionalBranch.isPresent()) {
            throw new BranchRequestException("Branch already exist!");
        }

        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setRegion(request.getAddress().getRegion());
        branchAddress.setDistrict(request.getAddress().getDistrict());
        branchAddress.setStreet(request.getAddress().getStreet());
        branchAddress.setHomeNumber(request.getAddress().getHomeNumber());
        branchAddress.setTarget(request.getAddress().getTarget());
        branchAddress.setAdditionalInfo(request.getAddress().getAdditionalInfo());
        branchAddress = addressRepository.save(branchAddress);

        ReqBranchCapacity reqCapacity = request.getCapacity();

        boolean isValid = this.validateCapacity(reqCapacity);
        if (!isValid) {
            throw new BranchRequestException("Invalid amount");
        }

        BranchOriginalCapacity branchCapacity = new BranchOriginalCapacity();
        branchCapacity.setTable2(reqCapacity.getTable2());
        branchCapacity.setTable4(reqCapacity.getTable4());
        branchCapacity.setTable8(reqCapacity.getTable8());
        branchCapacity.setTable12(reqCapacity.getTable12());
        branchCapacity.setTable20(reqCapacity.getTable20());
        branchCapacity.setSpecialRoom(reqCapacity.getSpecialRoom());
        branchCapacity.setHall(reqCapacity.getHall());
        branchCapacity.setToyxonaCapacity(reqCapacity.getToyxonaCapacity());
        branchCapacity = capacityRepo.save(branchCapacity);

        ActiveCapacity activeCapacity = new ActiveCapacity();
        activeCapacity.setTable2(reqCapacity.getTable2());
        activeCapacity.setTable4(reqCapacity.getTable4());
        activeCapacity.setTable8(reqCapacity.getTable8());
        activeCapacity.setTable12(reqCapacity.getTable12());
        activeCapacity.setTable20(reqCapacity.getTable20());
        activeCapacity.setSpecialRoom(reqCapacity.getSpecialRoom());
        activeCapacity.setHall(reqCapacity.getHall());
        activeCapacity.setToyxonaCapacity(reqCapacity.getToyxonaCapacity());
        activeCapacity = activeCapacityRepo.save(activeCapacity);

        Branch branch = new Branch();
        branch.setName(request.getName());
        branch.setDescription(request.getDescription());
        branch.setManager1Id(request.getManager1Id());
        branch.setManager2Id(request.getManager2Id());
        branch.setStatus(BranchStatus.INACTIVE);
        branch.setOpenAt(request.getOpenAt());
        branch.setCloseAt(request.getCloseAt());
        branch.setAddress(branchAddress);
        branch.setCapacity(branchCapacity);
        branch.setActiveCapacity(activeCapacity);

        repository.save(branch);

        return new SuccessMessage("Successfully registered!");
    }

    private boolean validateCapacity(ReqBranchCapacity reqCapacity) {

        return  reqCapacity.getTable2() >= 0 &&
                reqCapacity.getTable4() >= 0 &&
                reqCapacity.getTable8() >= 0 &&
                reqCapacity.getTable12() >= 0 &&
                reqCapacity.getTable20() >= 0 &&
                reqCapacity.getSpecialRoom() >= 0 &&
                reqCapacity.getHall() >= 0 &&
                reqCapacity.getToyxonaCapacity() >= 0;
    }

    @Override
    public List<ResBranch> getAllBranches() {
        List<Branch> all = repository.findAllByStatus(BranchStatus.ACTIVE);

        List<ResBranch> resultList = new ArrayList<>();

        for (Branch branch : all) {

            ResBranch resBranch = new ResBranch();
            resBranch.setName(branch.getName());
            resBranch.setDescription(branch.getDescription());
            resBranch.setOpenAt(branch.getOpenAt());
            resBranch.setCloseAt(branch.getCloseAt());
            resBranch.setGrade(branch.getGrade());
            resBranch.setAddress(branch.getAddress());

            resultList.add(resBranch);
        }

        return resultList;
    }

    @Override
    public ResBranch getOneBranch(ReqBranchId request) {

        Optional<Branch> optionalBranch = repository.findById(request.getId());
        if (optionalBranch.isEmpty()) {
            throw new EntityNotFoundException("Branch not found!");
        }
        Branch branch = optionalBranch.get();

        ResBranch resBranch = new ResBranch();
        resBranch.setName(branch.getName());
        resBranch.setDescription(branch.getDescription());
        resBranch.setOpenAt(branch.getOpenAt());
        resBranch.setCloseAt(branch.getCloseAt());
        resBranch.setGrade(branch.getGrade());
        resBranch.setAddress(branch.getAddress());

        return resBranch;
    }

}
