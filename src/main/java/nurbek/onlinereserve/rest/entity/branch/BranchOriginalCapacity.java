package nurbek.onlinereserve.rest.entity.branch;

// Abduraximov Nurbek  3/16/2024   12:31 PM

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "branch_original_capacity")
public class BranchOriginalCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer table2;

    private Integer table4;

    private Integer table8;

    private Integer table12;

    private Integer table20;

}
