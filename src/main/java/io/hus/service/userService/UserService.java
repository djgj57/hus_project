package io.hus.service.userService;

import io.hus.entity.userEntity.Role;
import io.hus.entity.userEntity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
    void deleteUser(User username);
    User getUserByToken(String token) throws Exception;
    void setEnabledToTrue(User user);
    void favoriteToUser(String token, Long productId) throws Exception;
}
