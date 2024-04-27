package nurbek.onlinereserve.rest.payload.res;

// Abduraximov Nurbek  4/27/2024   9:19 PM

import lombok.*;
import nurbek.onlinereserve.rest.enums.UserRole;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResUserMe implements Serializable {

    private String userId;

    private String firstName;

    private String lastName;

    private String phone;

    private Long balance;

    private String email;

    private UserRole role;

}
