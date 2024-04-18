package nurbek.onlinereserve.rest.service.impl;

// Abduraximov Nurbek  4/11/2024   11:33 AM

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.exception.BranchRequestException;
import nurbek.onlinereserve.config.exception.CustomException;
import nurbek.onlinereserve.config.security.JwtUtils;
import nurbek.onlinereserve.rest.entity.UserProfile;
import nurbek.onlinereserve.rest.enums.UserRole;
import nurbek.onlinereserve.rest.enums.UserStatus;
import nurbek.onlinereserve.rest.payload.req.auth.ReqAuthentication;
import nurbek.onlinereserve.rest.payload.req.auth.ReqRegisterUser;
import nurbek.onlinereserve.rest.payload.res.auth.ResAuthentication;
import nurbek.onlinereserve.rest.repo.UserProfileRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserProfileRepo userProfileRepo;
    private final UserProfileServiceImpl userProfileService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public ResAuthentication registerUser(ReqRegisterUser request) throws CustomException {

        Optional<UserProfile> optionalUser = userProfileRepo.findByEmail(request.getEmail());
        if (optionalUser.isPresent()) {
            throw new CustomException("User already exist!");
        }

        UserProfile user = new UserProfile();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setBalance(0L);
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(UserRole.USER);
        user = userProfileRepo.saveAndFlush(user);

        UserDetails userDetails = userProfileService.createUserDetails(user);

        var jwtToken = jwtUtils.generateToken(userDetails);

        ResAuthentication token = new ResAuthentication();
        token.setToken(jwtToken);
        return token;
    }

    public ResAuthentication authenticate(ReqAuthentication request) throws BranchRequestException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        Optional<UserProfile> optionalUser = userProfileRepo.findByEmail(request.getEmail());
        if (optionalUser.isEmpty()) {
            throw new BranchRequestException("User does not exist!");
        }
        UserProfile userProfile = optionalUser.get();

        UserDetails userDetails = userProfileService.createUserDetails(userProfile);

        var jwtToken = jwtUtils.generateToken(userDetails);

        ResAuthentication token = new ResAuthentication();
        token.setToken(jwtToken);
        return token;
    }

}
