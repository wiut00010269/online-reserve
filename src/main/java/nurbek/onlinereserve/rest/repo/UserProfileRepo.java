package nurbek.onlinereserve.rest.repo;

import nurbek.onlinereserve.base.BaseRepositoryLong;
import nurbek.onlinereserve.rest.entity.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserProfileRepo extends BaseRepositoryLong<UserProfile> {

    Optional<UserProfile> findByEmail(String email);

    Optional<UserProfile> findByUuid(UUID uuid);

}
