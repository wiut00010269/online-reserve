package nurbek.onlinereserve.rest.repo;

// Abduraximov Nurbek  1/11/2024   4:56 PM

import nurbek.onlinereserve.base.BaseRepositoryLong;
import nurbek.onlinereserve.rest.entity.branch.Branch;
import nurbek.onlinereserve.rest.enums.BranchStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BranchRepository extends BaseRepositoryLong<Branch> {

    List<Branch> findAllByStatus(BranchStatus status);

    Optional<Branch> findByName(String name);

    Optional<Branch> findByUuid(UUID uuid);

    List<Branch> findAllByManager1Id(String manager1Id);

    @Query(value = "SELECT * FROM branch ORDER BY created_at DESC LIMIT :count",
            nativeQuery = true)
    List<Branch> findLatestBranches(@Param("count") int count);

    @Query(value = "SELECT b.* " +
            "FROM branch b " +
            "JOIN appointment a ON b.uuid = a.branch_id " +
            "WHERE a.status = 'FINISHED' " +
            "GROUP BY b.id " +
            "ORDER BY COUNT(a.id) DESC " +
            "LIMIT :count", nativeQuery = true)
    List<Branch> findTopAppointedBranches(@Param("count") int count);

}
