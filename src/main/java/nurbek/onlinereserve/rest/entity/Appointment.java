package nurbek.onlinereserve.rest.entity;

// Abduraximov Nurbek  1/8/2024   10:39 AM

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nurbek.onlinereserve.base.BaseEntityLong;
import nurbek.onlinereserve.rest.enums.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class Appointment extends BaseEntityLong {

    @Column(name = "uuid", unique = true, nullable = false, updatable = false)
    private UUID uuid = UUID.randomUUID();

    private String userId;

    private String branchId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppointmentStatus status;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private Long depositPrice;

}
