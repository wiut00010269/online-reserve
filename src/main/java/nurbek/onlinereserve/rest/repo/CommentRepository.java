package nurbek.onlinereserve.rest.repo;

// Abduraximov Nurbek  3/24/2024   6:01 PM

import nurbek.onlinereserve.base.BaseRepositoryLong;
import nurbek.onlinereserve.rest.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends BaseRepositoryLong<Comment> {

    List<Comment> findAllByBranchUuid(String branchUuid);

}
