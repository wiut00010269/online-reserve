package nurbek.onlinereserve.rest.entity;

// Abduraximov Nurbek  1/8/2024   10:39 AM

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nurbek.onlinereserve.base.BaseEntity;
import nurbek.onlinereserve.rest.enums.AppointmentStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class Appointment extends BaseEntity {

    private String userId;

    private String branchId;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private String depositPrice;

}
