package io.hus.entity.reservationEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.hus.entity.productEntity.Product;
import io.hus.entity.userEntity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@Table(name = "tlb_reservations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private LocalDate checkIn;

    private LocalDate checkOut;
    private LocalTime eta; //Estimated Time of Arrival

    private String city;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_ID"))
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_ID"))
    private Product product;
}