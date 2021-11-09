package io.hus.repository.userRepo;

import io.hus.entity.userEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsernameIgnoreCase(String username);
}
