package nurbek.onlinereserve.rest.entity.branch;

// Abduraximov Nurbek 20/03/2024   12:00

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "active_capacity")
public class ActiveCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer table2;

    private Integer table4;

    private Integer table8;

    private Integer table12;

    private Integer table20;

    private Integer specialRoom;

    private Integer hall;

    private Integer toyxonaCapacity;
}
