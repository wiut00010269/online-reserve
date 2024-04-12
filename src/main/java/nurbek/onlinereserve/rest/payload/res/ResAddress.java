package nurbek.onlinereserve.rest.payload.res;

// Abduraximov Nurbek  4/12/2024   9:39 PM

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResAddress implements Serializable {

    private String region;

    private String district;

    private String street;

    private Long homeNumber;

    private String target;

    private String additionalInfo;

}
