package nurbek.onlinereserve.rest.service.impl;

// Abduraximov Nurbek  1/11/2024   4:26 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.core.GlobalVar;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.config.exception.CustomException;
import nurbek.onlinereserve.rest.entity.branch.ActiveCapacity;
import nurbek.onlinereserve.rest.entity.branch.Branch;
import nurbek.onlinereserve.rest.entity.branch.BranchAddress;
import nurbek.onlinereserve.rest.entity.branch.BranchOriginalCapacity;
import nurbek.onlinereserve.rest.enums.BranchStatus;
import nurbek.onlinereserve.rest.external.StorageService;
import nurbek.onlinereserve.rest.payload.req.ReqCount;
import nurbek.onlinereserve.rest.payload.req.ReqId;
import nurbek.onlinereserve.rest.payload.req.ReqUUID;
import nurbek.onlinereserve.rest.payload.req.branch.*;
import nurbek.onlinereserve.rest.payload.res.ResAddress;
import nurbek.onlinereserve.rest.payload.res.branch.ResBranch;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import nurbek.onlinereserve.rest.payload.res.branch.ResMyBranch;
import nurbek.onlinereserve.rest.repo.*;
import nurbek.onlinereserve.rest.service.BranchService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository repository;
    private final BranchAddressRepository addressRepository;
    private final BranchOriginalCapacityRepo capacityRepo;
    private final ActiveCapacityRepo activeCapacityRepo;
    private final BranchRateRepository rateRepository;

    private final StorageService storageService;

    private final GlobalVar globalVar;

    //**=========================== Admin Panel ================================**//

    @Override
    public SuccessMessage registerBranch(ReqRegisterBranch request) throws BranchRequestException, CustomException {

        Optional<Branch> optionalBranch = repository.findByName(request.getName());
        if (optionalBranch.isPresent()) {
            throw new BranchRequestException("Branch already exist!");
        }

        String currentUserUUID = globalVar.getCurrentUserUUID();

        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setRegion(request.getAddress().getRegion());
        branchAddress.setDistrict(request.getAddress().getDistrict());
        branchAddress.setStreet(request.getAddress().getStreet());
        branchAddress.setHomeNumber(request.getAddress().getHomeNumber());
        branchAddress.setTarget(request.getAddress().getTarget());
        branchAddress.setMap(request.getAddress().getMap());
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
        branchCapacity = capacityRepo.save(branchCapacity);

        ActiveCapacity activeCapacity = new ActiveCapacity();
        activeCapacity.setTable2(reqCapacity.getTable2());
        activeCapacity.setTable4(reqCapacity.getTable4());
        activeCapacity.setTable8(reqCapacity.getTable8());
        activeCapacity.setTable12(reqCapacity.getTable12());
        activeCapacity.setTable20(reqCapacity.getTable20());
        activeCapacity = activeCapacityRepo.save(activeCapacity);

        Branch branch = new Branch();
        branch.setName(request.getName());
        branch.setDescription(request.getDescription());
        branch.setManager1Id(currentUserUUID);
        branch.setStatus(BranchStatus.INACTIVE);
        branch.setOpenAt(request.getOpenAt());
        branch.setCloseAt(request.getCloseAt());
        branch.setImgUrl(request.getImgUrl());
        branch.setAddress(branchAddress);
        branch.setCapacity(branchCapacity);
        branch.setActiveCapacity(activeCapacity);

        repository.save(branch);

        return new SuccessMessage("Successfully registered!");
    }

    @Override
    public SuccessMessage updateBranch(ReqUpdateBranch request) throws BranchRequestException {

        Optional<Branch> optionalBranch = repository.findById(request.getId());
        if (optionalBranch.isEmpty()) {
            throw new BranchRequestException("Restaurant not found!");
        }
        Branch branch = optionalBranch.get();

        ReqBranchAddress reqAddress = request.getAddress();
        BranchAddress address = branch.getAddress();
        address.setRegion(reqAddress.getRegion());
        address.setDistrict(reqAddress.getDistrict());
        address.setStreet(reqAddress.getStreet());
        address.setHomeNumber(reqAddress.getHomeNumber());
        address.setTarget(reqAddress.getTarget());
        address = addressRepository.save(address);

        ReqBranchCapacity reqCapacity = request.getCapacity();
        BranchOriginalCapacity capacity = branch.getCapacity();
        capacity.setTable2(reqCapacity.getTable2());
        capacity.setTable4(reqCapacity.getTable4());
        capacity.setTable8(reqCapacity.getTable8());
        capacity.setTable12(reqCapacity.getTable12());
        capacity.setTable20(reqCapacity.getTable20());
        capacity = capacityRepo.save(capacity);

        branch.setName(request.getName());
        branch.setDescription(request.getDescription());
        branch.setOpenAt(request.getOpenAt());
        branch.setCloseAt(request.getCloseAt());
        branch.setStatus(request.getStatus());
        branch.setAddress(address);
        branch.setCapacity(capacity);
        repository.save(branch);

        return new SuccessMessage("Restaurant successfully updated!");
    }

    @Override
    public List<ResMyBranch> myBranchList() throws CustomException {

        String currentUserUUID = globalVar.getCurrentUserUUID();

        List<Branch> branches = repository.findAllByManager1Id(currentUserUUID);

        List<ResMyBranch> resultList = new ArrayList<>();
        for (Branch branch : branches) {

            BranchAddress address = branch.getAddress();

            ResAddress resAddress = new ResAddress();
            resAddress.setRegion(address.getRegion());
            resAddress.setDistrict(address.getDistrict());
            resAddress.setStreet(address.getStreet());
            resAddress.setHomeNumber(address.getHomeNumber());
            resAddress.setTarget(address.getTarget());

            ResMyBranch myBranch = new ResMyBranch();
            myBranch.setId(branch.getId());
            myBranch.setName(branch.getName());
            myBranch.setDescription(branch.getDescription());
            myBranch.setOpenAt(branch.getOpenAt());
            myBranch.setCloseAt(branch.getCloseAt());
            myBranch.setStatus(branch.getStatus());
            myBranch.setGrade(branch.getGrade());
            myBranch.setAddress(resAddress);

            resultList.add(myBranch);
        }

        return resultList;
    }

    @Override
    public SuccessMessage deleteMyBranch(ReqId request) throws BranchRequestException {

        Optional<Branch> optionalBranch = repository.findById(request.getId());
        if (optionalBranch.isEmpty()) {
            throw new BranchRequestException("Branch not found!");
        }
        Branch branch = optionalBranch.get();

        if (BranchStatus.DELETED.equals(branch.getStatus())) {
            throw new BranchRequestException("Branch already deleted!");
        }

        branch.setStatus(BranchStatus.DELETED);
        repository.save(branch);

        return new SuccessMessage("Deleted!");
    }

    private boolean validateCapacity(ReqBranchCapacity reqCapacity) {

        return  reqCapacity.getTable2() >= 0 &&
                reqCapacity.getTable4() >= 0 &&
                reqCapacity.getTable8() >= 0 &&
                reqCapacity.getTable12() >= 0 &&
                reqCapacity.getTable20() >= 0;
    }


    //**=========================== User Side ================================**//

    @Override
    public List<ResBranch> getAllBranches() {
        List<Branch> all = repository.findAllByStatus(BranchStatus.ACTIVE);

        return getResBranches(all);
    }

    @Override
    public ResBranch getOneBranch(ReqUUID request) throws BranchRequestException {

        Optional<Branch> optionalBranch = repository.findByUuid(request.getUuid());
        if (optionalBranch.isEmpty()) {
            throw new BranchRequestException("Branch not found!");
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

    @Override
    public SuccessMessage rateBranch(ReqRate request) throws BranchRequestException {

        Optional<Branch> optionalBranch = repository.findByUuid(UUID.fromString(request.getBranchUuid()));
        if (optionalBranch.isEmpty()) {
            throw new BranchRequestException("Branch not found!");
        }
        Branch branch = optionalBranch.get();

        double grade = Double.parseDouble(branch.getGrade());
        Integer count = rateRepository.getCount(branch.getUuid().toString());

        double rate = (grade * count + request.getRate()) / (count + 1);

        branch.setGrade(String.valueOf(rate));
        repository.save(branch);

        return new SuccessMessage("Thank you!");
    }

    @Override
    public List<ResBranch> getNewestRestaurants(ReqCount request) throws BranchRequestException {

        if (request.getCount() <= 0) {
            throw new BranchRequestException("Invalid count!");
        }

        List<Branch> latestBranches = repository.findLatestBranches(request.getCount());

        return getResBranches(latestBranches);
    }

    @Override
    public List<ResBranch> getTopBookedRestaurants(ReqCount request) throws BranchRequestException {

        if (request.getCount() <= 0) {
            throw new BranchRequestException("Invalid count!");
        }

        List<Branch> topAppointedBranches = repository.findTopAppointedBranches(request.getCount());

        return getResBranches(topAppointedBranches);
    }

    @Override
    public String uploadRestaurantFile(MultipartFile file) {
        return storageService.uploadFile(file);
    }

    private List<ResBranch> getResBranches(List<Branch> topAppointedBranches) {
        List<ResBranch> resultList = new ArrayList<>();
        for (Branch latestBranch : topAppointedBranches) {

            ResBranch resBranch = new ResBranch();
            resBranch.setBranchUuid(latestBranch.getUuid().toString());
            resBranch.setName(latestBranch.getName());
            resBranch.setDescription(latestBranch.getDescription());
            resBranch.setOpenAt(latestBranch.getOpenAt());
            resBranch.setCloseAt(latestBranch.getCloseAt());
            resBranch.setGrade(latestBranch.getGrade());
            resBranch.setAddress(latestBranch.getAddress());
            resultList.add(resBranch);
        }

        return resultList;
    }

}
