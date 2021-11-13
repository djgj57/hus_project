package io.hus.entity.productEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hus.entity.categoryEntity.Category;
import io.hus.entity.cityEntity.City;
import io.hus.entity.featureEntity.Feature;
import io.hus.entity.imageEntity.Image;
import io.hus.entity.reservationEntity.Reservation;
import io.hus.entity.userEntity.Role;
import io.hus.entity.userEntity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    /* ***************** attributes ***************** */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "tbl_product_feature",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private Set<Feature> features;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @Column(unique = true)
    private Set<Image> images;

    @ManyToOne
    private Category category;

    @ManyToOne
    private City city;

    private Boolean available;

    private Double latitude;

    private Double longitude;

    @Max(value = 5) @Min(value = 0)
    private double score; // de 1 a 5

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Reservation> reservations;

    /* ***************** constructor ***************** */

    public Product(Long id, String name, String description, Set<Feature> features,
                   Set<Image> images, Category category, City city, Boolean available,
                   Double latitude, Double longitude, double score) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.features = features;
        this.images = images;
        this.category = category;
        this.city = city;
        this.available = true;
        this.latitude = latitude;
        this.longitude = longitude;
        this.score = score;
    }
}