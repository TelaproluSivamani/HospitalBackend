package com.HealthCare.Management.Controller;

import com.HealthCare.Management.Entity.User;
import com.HealthCare.Management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;.
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")  // base URL for frontend
@CrossOrigin(origins = "*") // allow React frontend to access (Vite default port 8080)
public class UserController {

    @Autowired
    private UserService userService;

    // Signup (Register new user)
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // Login (Validate user credentials)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userService.validateUser(loginRequest.getUserName(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user); // return user details on successful login
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    // Get User by Id (optional - if you want profile fetching)
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
