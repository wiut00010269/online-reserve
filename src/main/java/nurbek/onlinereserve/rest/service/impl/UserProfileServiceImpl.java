package nurbek.onlinereserve.rest.service.impl;

// Abduraximov Nurbek  4/10/2024   10:00 PM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.core.GlobalVar;
import nurbek.onlinereserve.config.exception.CustomException;
import nurbek.onlinereserve.rest.entity.UserProfile;
import nurbek.onlinereserve.rest.enums.UserStatus;
import nurbek.onlinereserve.rest.payload.res.ResUserMe;
import nurbek.onlinereserve.rest.repo.UserProfileRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserDetailsService {

    private final UserProfileRepo userProfileRepo;
    private final GlobalVar globalVar;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserProfile> userProfileOptional = userProfileRepo.findByEmail(email);
        UserProfile userProfile = userProfileOptional.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return createUserDetails(userProfile);
    }

    public UserDetails createUserDetails(UserProfile userProfile) {
        return new org.springframework.security.core.userdetails.User(
                userProfile.getEmail(),
                userProfile.getPassword(),
                userProfile.getStatus() == UserStatus.ACTIVE,
                true,
                true,
                true,
                Collections.singletonList(new SimpleGrantedAuthority(userProfile.getRole().name()))
        );
    }

    public ResUserMe infoMe() throws CustomException {

        UserProfile currentUser = globalVar.getCurrentUser();

        ResUserMe resUser = new ResUserMe();
        resUser.setUserId(currentUser.getUuid().toString());
        resUser.setFirstName(currentUser.getFirstName());
        resUser.setLastName(currentUser.getLastName());
        resUser.setBalance(currentUser.getBalance());
        resUser.setEmail(currentUser.getEmail());
        resUser.setPhone(currentUser.getPhone());
        resUser.setRole(currentUser.getRole());

        return resUser;
    }
}
