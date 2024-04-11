package nurbek.onlinereserve.rest.payload.res.auth;

// Abduraximov Nurbek  4/11/2024   11:25 AM

import lombok.*;

import java.io.Serializable;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResAuthentication implements Serializable {

    private String token;

}
