package nurbek.onlinereserve.rest.entity;

// Abduraximov Nurbek  3/24/2024   5:28 PM

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nurbek.onlinereserve.base.BaseEntityLong;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment extends BaseEntityLong {

    private String userUuid;

    private String branchUuid;

    private String user;

    private String comment;

    private Double grade;

}
