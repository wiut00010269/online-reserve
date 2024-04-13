package nurbek.onlinereserve.config.core;

// Abduraximov Nurbek  1/9/2024   11:54 AM

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.rest.entity.UserProfile;
import nurbek.onlinereserve.rest.repo.UserProfileRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GlobalVar {

    private final UserProfileRepo userProfileRepo;

    private final static ThreadLocal<String> H_REQUEST_ID = ThreadLocal.withInitial(String::new);

    public static void setRequestId(String requestId) {
        GlobalVar.H_REQUEST_ID.set(requestId);
    }

    public static String getRequestId() {
        return GlobalVar.H_REQUEST_ID.get();
    }

    public String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public String getCurrentUserUUID() {

        String currentUsername = getCurrentUsername();

        Optional<UserProfile> optionalUser = userProfileRepo.findByEmail(currentUsername);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("User not found!");
        }
        UserProfile userProfile = optionalUser.get();

        return userProfile.getUuid().toString();
    }

    public UserProfile getCurrentUser() {

        String currentUsername = getCurrentUsername();

        Optional<UserProfile> optionalUser = userProfileRepo.findByEmail(currentUsername);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("User not found!");
        }

        return optionalUser.get();
    }


}
