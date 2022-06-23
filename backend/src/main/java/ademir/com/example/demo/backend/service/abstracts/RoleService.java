package ademir.com.example.demo.backend.service.abstracts;

import ademir.com.example.demo.backend.model.EnumRole;
import ademir.com.example.demo.backend.model.Role;
import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(EnumRole role);
}
