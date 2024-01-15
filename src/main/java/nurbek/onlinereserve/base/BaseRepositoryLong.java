package nurbek.onlinereserve.base;

// Abduraximov Nurbek  1/11/2024   4:57 PM

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepositoryLong<R extends BaseEntityLong> extends JpaRepository<R, Long> {
}
