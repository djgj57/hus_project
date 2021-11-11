package io.hus.entity.categoryEntity;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "tbl_categories")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "The title must not be empty")
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    private String imageURL = "https://image.freepik.com/vector-gratis/proximamente-fondo-diseno-spot-light_1017-25515.jpg";
    private String status;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
}
