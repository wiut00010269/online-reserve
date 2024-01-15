package nurbek.onlinereserve.rest.entity;

// Abduraximov Nurbek  1/6/2024   3:43 PM

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nurbek.onlinereserve.base.BaseEntityLong;
import nurbek.onlinereserve.rest.enums.UserStatus;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_profile")
public class UserProfile extends BaseEntityLong {

    @Column(name = "uuid", unique = true, nullable = false, updatable = false)
    private UUID uuid = UUID.randomUUID();

    private String firstName;

    private String lastName;

    private String phone;

    private Long balance;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String email;

    @Column(unique = true)
    private String username;

    private String password;

}
