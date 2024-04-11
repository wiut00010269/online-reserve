package nurbek.onlinereserve.rest.payload.req.auth;

// Abduraximov Nurbek  4/11/2024   11:26 AM

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class  ReqRegisterUser implements Serializable {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
