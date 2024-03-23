package nurbek.onlinereserve.rest.endpoint.controller;

// Abduraximov Nurbek  1/8/2024   5:41 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.rest.endpoint.AppointmentEndpoint;
import nurbek.onlinereserve.rest.entity.branch.Branch;
import nurbek.onlinereserve.rest.payload.req.appointment.ReqAppointment;
import nurbek.onlinereserve.rest.repo.BranchRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AppointmentController implements AppointmentEndpoint {

    private final BranchRepository branchRepository;

    @Override
    public ResponseEntity<?> makeAppointment(ReqAppointment reqAppointment) throws BranchRequestException {

        Optional<Branch> optionalBranch = branchRepository.findByUuid(UUID.fromString(reqAppointment.getBranchUuid()));
        if (optionalBranch.isEmpty()) {
            throw new BranchRequestException("Branch not found!");
        }
        Branch branch = optionalBranch.get();


        return null;
    }
}
