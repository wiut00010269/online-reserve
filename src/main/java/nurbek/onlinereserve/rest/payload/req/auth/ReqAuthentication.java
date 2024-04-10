package nurbek.onlinereserve.rest.payload.req.auth;

// Abduraximov Nurbek  4/10/2024   9:41 PM

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqAuthentication implements Serializable {

    private String email;

    private String password;

}
