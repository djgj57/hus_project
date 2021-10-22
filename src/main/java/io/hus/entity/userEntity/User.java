package io.hus.entity.userEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.*;


@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "tbl_users")
public class User {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty(message = "The name must not be empty")
    private String name;
    private String lastname;
    @NotNull
    @Column(unique=true)
    private String username;
    @NotNull
    @Size(min = 7)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
