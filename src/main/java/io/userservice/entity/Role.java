package io.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static javax.persistence.GenerationType.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Min(value = 1, message = "Age should not be less than 15")
    @Max(value = 1, message = "Age should not be greater than 65")
    private Long id;
    private String name;
}
