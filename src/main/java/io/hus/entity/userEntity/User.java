package io.hus.entity.userEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.hus.entity.imageEntity.Image;
import io.hus.entity.reservationEntity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static javax.persistence.GenerationType.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_users")
public class User {

    /* ***************** attributes ***************** */

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "The name must not be empty")
    private String name;

    private String lastname;
    @NotNull
    @Column(unique = true)
    private String username; // email

    @JsonProperty( value = "password", access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 7)
    private String password;

    @JsonProperty( value = "roles", access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    private boolean isEnabled;


    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Reservation> reservations;

    @ElementCollection
    private Collection<Long> favorites = new ArrayList<>();

    /* ***************** methods ***************** */

    public void setEnabled(boolean enable) {
        isEnabled = enable;
    }
}
