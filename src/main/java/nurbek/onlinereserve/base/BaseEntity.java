package nurbek.onlinereserve.base;

// Abduraximov Nurbek  1/6/2024   3:44 PM

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    public Long id;

    @GenericGenerator(name = "uuid")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @Column(unique = true, updatable = false, nullable = false)
    public UUID uuid = UUID.randomUUID();

    @JsonIgnore
    @JsonIgnoreProperties
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    public LocalDateTime createdAt;

    @JsonIgnore
    @JsonIgnoreProperties
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    public LocalDateTime updatedAt;

}
