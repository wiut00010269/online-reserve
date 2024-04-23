package nurbek.onlinereserve.rest.repo;

// Abduraximov Nurbek 23/04/2024   18:01

import nurbek.onlinereserve.base.BaseRepositoryLong;
import nurbek.onlinereserve.rest.entity.branch.BranchRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRateRepository extends BaseRepositoryLong<BranchRate> {

    @Query(value = "SELECT count(*) FROM branch_rate WHERE branch_uuid=:branchId",
            nativeQuery = true)
    Integer getCount(@Param("branchId") String branchId);

}
