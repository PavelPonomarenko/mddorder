package ua.com.mddorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.mddorder.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}



