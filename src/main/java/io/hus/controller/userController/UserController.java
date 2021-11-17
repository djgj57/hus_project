package io.hus.controller.userController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hus.entity.userEntity.ConfirmationToken;
import io.hus.entity.userEntity.RoleToUserForm;
import io.hus.repository.emailRepo.ConfirmationTokenRepo;
import io.hus.service.emailService.EmailSenderService;
import io.swagger.v3.oas.annotations.Operation;
import io.hus.entity.userEntity.Role;
import io.hus.entity.userEntity.User;
import io.hus.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ConfirmationTokenRepo confirmationTokenRepo;
    private final EmailSenderService emailSenderService;

    @Operation(summary = "Login")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password,
                                   HttpServletResponse response) throws Exception {
        return ResponseEntity.ok().body("ok");
    }


    @Operation(summary = "List all users")
    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @Operation(summary = "Search a user by token")
    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestHeader String Authorization) throws Exception {
        User user = userService.getUserByToken(Authorization);
        return ResponseEntity.ok().body(user);
    }

    @Operation(summary = "Register a new user")
    @PostMapping("/open/user/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {

        User existingUser = userService.getUser(user.getUsername());
        if (user.getPassword().length() < 7) {
            return ResponseEntity.badRequest().body("Password must be at least 7 characters long");
        }
        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists.");
        } else {

            try {
                URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path(
                        "/api/open/user/save").toUriString());
                Collection<Role> roles = Collections.singleton(new Role(1L, "ROLE_USER"));
                user.setRoles(roles);
                user.setId(null);
                user.setEnabled(false);
                User userDB = userService.saveUser(user);

                ConfirmationToken confirmationToken = new ConfirmationToken(user);
                confirmationTokenRepo.save(confirmationToken);

                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(user.getUsername());
                mailMessage.setSubject("Hus complete Registration!");
                mailMessage.setFrom("hus.group5@gmail.comm");
                mailMessage.setText("To confirm your Hus account, please click here : "
                        + "http://localhost:8080/api/open/confirm?token=" + confirmationToken.getConfirmationToken());
                emailSenderService.sendEmail(mailMessage);
                return ResponseEntity.created(uri).body("Successful registration. please verify account.");
            } catch (Exception e) {
                return ResponseEntity
                        .status(FORBIDDEN)
                        .body("error: " + e.getMessage());
            }
        }
    }

    //    TODO: no es posible elimiar por relaciones. revisar.
    @Operation(summary = "Delete a user by token -- In progress... -- ")
    @DeleteMapping("/user")
    public ResponseEntity<?> deleteUser(@RequestHeader String Authorization) throws Exception {
        User user = userService.getUserByToken(Authorization);
        userService.deleteUser(user);
        return null;

    }

    @Operation(summary = "Confirm user account")
    @RequestMapping(value = "/open/confirm", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token") String confirmationToken) {
        ResponseEntity<?> response = null;
        ConfirmationToken token = confirmationTokenRepo.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User user = userService.getUser(token.getUser().getUsername());
            userService.setEnabledToTrue(user);
            response = ResponseEntity.ok().body("Account successfully verified. Now you can close this window and log into the Hub");
        } else {
            response = ResponseEntity.badRequest().body("The link is invalid or broken!");
        }
        return response;
    }

    @Operation(summary = "Register a new role")
    @PostMapping("/admin/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role" +
                "/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @Operation(summary = "Add role to user")
    @PostMapping("/admin/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Add/remove favorite product to user")
    @RequestMapping(value = "/user/favorite/{productid}", method = {RequestMethod.DELETE,
            RequestMethod.POST})
    public ResponseEntity<?> addOrRemoveFavoriteToUser(@PathVariable("productid") Long productid,
                                                       @RequestHeader String Authorization) throws Exception {
        userService.favoriteToUser(Authorization, productid);
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "Refresh a token")
    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 7 * 8 * 60 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",
                                user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
//                    response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

}


