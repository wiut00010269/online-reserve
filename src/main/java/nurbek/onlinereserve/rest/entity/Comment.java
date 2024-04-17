package nurbek.onlinereserve.rest.entity;

// Abduraximov Nurbek  3/24/2024   5:28 PM


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nurbek.onlinereserve.base.BaseEntityLong;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment extends BaseEntityLong {

    private String userUuid;

    private String branchUuid;

    private String commenter;

    private String comment;

    private Double grade;

}
