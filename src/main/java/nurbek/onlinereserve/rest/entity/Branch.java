package nurbek.onlinereserve.rest.entity;

// Abduraximov Nurbek  1/6/2024   4:51 PM

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nurbek.onlinereserve.base.BaseEntity;
import nurbek.onlinereserve.rest.enums.BranchStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "branch")
public class Branch extends BaseEntity {

    private String name;

    private String location;

    private String description;

    private String manager1Id;

    private String manager2Id;

    @Enumerated(EnumType.STRING)
    private BranchStatus status;

    private LocalDateTime openAt;

    private LocalDateTime closeAt;

    private String grade;

}
