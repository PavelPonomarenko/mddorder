package ua.com.mddorder.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.mddorder.model.Role;
import ua.com.mddorder.model.RoleType;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}
