package nurbek.onlinereserve.rest.entity.branch;

// Abduraximov Nurbek  3/16/2024   12:31 PM

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
@Table(name = "branch_capacity")
public class BranchCapacity extends BaseEntityLong {

    private Integer table2;

    private Integer table4;

    private Integer table8;

    private Integer table12;

    private Integer table20;

    private Integer specialRoom;

    private Integer hall;

    private Integer toyxonaCapacity;
}
