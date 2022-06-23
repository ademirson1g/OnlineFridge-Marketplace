package ademir.com.example.demo.backend.service.abstracts;

import org.springframework.http.ResponseEntity;
import ademir.com.example.demo.backend.payload.request.LoginRequest;
import ademir.com.example.demo.backend.payload.request.SignupRequest;


public interface AuthService {
	ResponseEntity<?> authenticateUser(LoginRequest loginRequest);

	ResponseEntity<?> registerUser(SignupRequest signupRequest);
}
