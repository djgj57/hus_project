package io.hus.entity.productEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hus.entity.categoryEntity.Category;
import io.hus.entity.cityEntity.City;
import io.hus.entity.featureEntity.Feature;
import io.hus.entity.imageEntity.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "tbl_product_feature",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private Set<Feature> features;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Image> images;
    @ManyToOne
    private Category category;
    @ManyToOne
    private City city;
//    private Set<Date> notAvailable;
//    private String status;
    private Double latitude;
    private Double longitude;
    private double score; // de 1 a 5
}
