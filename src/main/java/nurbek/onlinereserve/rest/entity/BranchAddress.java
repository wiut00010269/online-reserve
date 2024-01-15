package nurbek.onlinereserve.rest.entity;

// Abduraximov Nurbek  1/11/2024   6:56 PM

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nurbek.onlinereserve.base.BaseEntityLong;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "branch_address")
public class BranchAddress extends BaseEntityLong {

    private String region;

    private String district;

    private String street;

    private Long homeNumber;

    private String target;

    private String additionalInfo;

}
