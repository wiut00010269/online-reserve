package nurbek.onlinereserve.rest.repo;

// Abduraximov Nurbek  1/11/2024   4:56 PM

import nurbek.onlinereserve.base.BaseRepositoryLong;
import nurbek.onlinereserve.rest.entity.branch.Branch;
import nurbek.onlinereserve.rest.enums.BranchStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BranchRepository extends BaseRepositoryLong<Branch> {

    List<Branch> findAllByStatus(BranchStatus status);

    Optional<Branch> findByName(String name);

    Optional<Branch> findByUuid(UUID uuid);

}
