package ua.com.mddorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.mddorder.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
