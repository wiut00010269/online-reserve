package nurbek.onlinereserve.rest.entity.branch;

// Abduraximov Nurbek  1/11/2024   6:56 PM

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
@Table(name = "branch_address")
public class BranchAddress extends BaseEntityLong {

    private String region;

    private String street;

    private String map;

}
