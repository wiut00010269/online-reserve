package nurbek.onlinereserve.rest.payload.req;

// Abduraximov Nurbek  4/28/2024   4:55 AM

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReqAddUser implements Serializable {

    private String email;

    private String firstName;

    private String lastName;

}
