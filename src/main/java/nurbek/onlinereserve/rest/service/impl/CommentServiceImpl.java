package nurbek.onlinereserve.rest.service.impl;

// Abduraximov Nurbek  3/24/2024   5:59 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.core.GlobalVar;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.config.exception.CustomException;
import nurbek.onlinereserve.rest.entity.Appointment;
import nurbek.onlinereserve.rest.entity.Comment;
import nurbek.onlinereserve.rest.entity.UserProfile;
import nurbek.onlinereserve.rest.entity.branch.Branch;
import nurbek.onlinereserve.rest.enums.AppointmentStatus;
import nurbek.onlinereserve.rest.payload.req.ReqComment;
import nurbek.onlinereserve.rest.payload.res.SuccessMessage;
import nurbek.onlinereserve.rest.repo.AppointmentRepository;
import nurbek.onlinereserve.rest.repo.BranchRepository;
import nurbek.onlinereserve.rest.repo.CommentRepository;
import nurbek.onlinereserve.rest.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final AppointmentRepository appointmentRepository;
    private final BranchRepository branchRepository;
    private final GlobalVar globalVar;

    @Override
    public SuccessMessage writeReview(ReqComment request) throws BranchRequestException, CustomException {

        UserProfile userProfile = globalVar.getCurrentUser();
        UUID userUuid = userProfile.getUuid();

        Optional<Branch> optionalBranch = branchRepository.findByUuid(UUID.fromString(request.getBranchUuid()));
        if (optionalBranch.isEmpty()) {
            throw new BranchRequestException("Branch not found!");
        }
        Branch branch = optionalBranch.get();
        String branchId = branch.getUuid().toString();

        Optional<Appointment> optionalAppointment =
                appointmentRepository.findTopByUserIdAndBranchIdAndStatusOrderByCreatedAt(userUuid.toString(), branchId, AppointmentStatus.FINISHED);
        if (optionalAppointment.isEmpty()) {
            throw new CustomException("Appointment not found!");
        }

        Comment comment = new Comment();
        comment.setComment(request.getComment());
        comment.setUserUuid(userUuid.toString());
        comment.setBranchUuid(branchId);
        comment.setCommenter(userProfile.getFirstName() + " " + userProfile.getLastName());
        repository.save(comment);

        return new SuccessMessage("Done!");
    }

}
