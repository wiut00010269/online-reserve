package nurbek.onlinereserve.rest.entity;

// Abduraximov Nurbek  1/6/2024   3:43 PM

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nurbek.onlinereserve.base.BaseEntity;
import nurbek.onlinereserve.rest.enums.UserStatus;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_profile")
public class UserProfile extends BaseEntity {

    private String firstName;

    private String lastName;

    private String phone;

    private Long balance;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String email;

    @Column(unique = true)
    private String username;

}
