package io.hus.entity.imageEntity;

import io.hus.entity.productEntity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tlb_images")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String url = "https://image.freepik.com/vector-gratis/proximamente-fondo-diseno-spot-light_1017-25515.jpg";
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
}
