package ademir.com.example.demo.backend.service.abstracts;

import org.springframework.http.ResponseEntity;
import ademir.com.example.demo.backend.model.User;
import ademir.com.example.demo.backend.payload.request.SignupRequest;
import java.util.List;
import java.util.Optional;

public interface UserService {
   Optional<User> findByUsername(String username);

   User getById(Integer id);

   Boolean existsByUsername(String username);

   User save(User user);

   void deleteById(Integer id);

   List<User> findAll();

   ResponseEntity<?> add(SignupRequest signupRequest);
}
