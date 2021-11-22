package io.hus.service.userService;

import io.hus.entity.userEntity.Role;
import io.hus.entity.userEntity.User;
import io.hus.repository.userRepo.RoleRepo;
import io.hus.repository.userRepo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    final static Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsernameIgnoreCase(username);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else if (!user.isEnabled()) {
            log.error("Account not verified");
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            return new org.springframework.security.core.userdetails.User("UNAUTHORIZED",
                    user.getPassword(), authorities);
        } else {
            log.info("User found in the database: " + username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(), authorities);
        }
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user: " + user.getName() + " to the database");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role" + role.getName() + " to the database");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role " + roleName + " to user " + username);
        User user = userRepo.findByUsernameIgnoreCase(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user " + username);
        return userRepo.findByUsernameIgnoreCase(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(User user) {
        log.info("Deleting user " + user.getUsername());
        userRepo.delete(user);
    }

    @Override
    public User getUserByToken(String token) throws Exception {
        String response = token;
        response = response.substring(7).split("\\.")[1];
        response = new String(Base64.getDecoder().decode(response));
        JSONObject obj = new JSONObject(response);
        return this.getUser(obj.getString("sub"));
    }

    @Override
    public void setEnabledToTrue(User user) {
        user.setEnabled(true);
    }

    @Override
    public void favoriteToUser(String token, Long productId) throws Exception {
        User user = this.getUserByToken(token);
        if (!user.getFavorites().contains(productId)) {
            log.info("Adding favorite " + productId + " to user " + user.getUsername());
            user.getFavorites().add(productId);
        } else {
            log.info("Remove favorite " + productId + " to user " + user.getUsername());
            user.getFavorites().remove(productId);
        }
    }
}
