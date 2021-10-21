package io.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.*;


@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String lastname;
    @NotNull
    private String username;
    @NotNull
    @Size(min = 7)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
