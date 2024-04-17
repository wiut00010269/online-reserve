package nurbek.onlinereserve.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nurbek.onlinereserve.base.BaseEntityLong;
import nurbek.onlinereserve.rest.enums.UserRole;
import nurbek.onlinereserve.rest.enums.UserStatus;

import javax.persistence.*;
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

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
