package nurbek.onlinereserve.rest.entity.branch;

// Abduraximov Nurbek  1/6/2024   4:51 PM

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nurbek.onlinereserve.base.BaseEntityLong;
import nurbek.onlinereserve.rest.enums.BranchStatus;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "branch")
public class Branch extends BaseEntityLong {

    @Column(name = "uuid", unique = true, nullable = false, updatable = false)
    private UUID uuid = UUID.randomUUID();

    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private BranchAddress address;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String manager1Id;

    @Enumerated(EnumType.STRING)
    private BranchStatus status;

    private LocalTime openAt;

    private LocalTime closeAt;

    private String grade;

    @OneToOne
    @JoinColumn(name = "capacity_id")
    private BranchOriginalCapacity capacity;

    @OneToOne
    @JoinColumn(name = "active_capacity_id")
    private ActiveCapacity activeCapacity;

    @Column(name = "slug", unique = true)
    private String slug;

    private String imgUrl;

}
