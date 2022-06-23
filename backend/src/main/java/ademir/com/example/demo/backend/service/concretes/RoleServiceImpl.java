package ademir.com.example.demo.backend.service.concretes;

import org.springframework.stereotype.Service;
import ademir.com.example.demo.backend.model.EnumRole;
import ademir.com.example.demo.backend.model.Role;
import ademir.com.example.demo.backend.repository.RoleRepository;
import ademir.com.example.demo.backend.service.abstracts.RoleService;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByName(EnumRole role) {
        return this.roleRepository.findByName(role);
    }
}
