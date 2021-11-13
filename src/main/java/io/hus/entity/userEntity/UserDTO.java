package io.hus.entity.userEntity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String lastname;
    private String username; // email

}
