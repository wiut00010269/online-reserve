package nurbek.onlinereserve.rest.entity.branch;

// Abduraximov Nurbek 23/04/2024   17:22

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nurbek.onlinereserve.base.BaseEntityLong;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "branch_rate")
public class BranchRate extends BaseEntityLong {

    private String userUuid;

    private String branchUuid;

    private Double grade;

}
