package ademir.com.example.demo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ademir.com.example.demo.backend.model.User;
import ademir.com.example.demo.backend.payload.request.SignupRequest;
import ademir.com.example.demo.backend.service.abstracts.UserService;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/remove")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> remove(@RequestParam("user-id") Integer id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User removed from system");
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> add(@Valid @RequestBody SignupRequest signupRequest) {
        return userService.add(signupRequest);
    }
}
