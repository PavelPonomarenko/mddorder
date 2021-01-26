package ua.com.mddorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.mddorder.model.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT u FROM Employee u WHERE u.email=?1")
    Optional<Employee> findEmployeeByEmail(String email);

    @Query("SELECT u FROM Employee u WHERE u.id=?1")
    Optional<Employee> findEmployeeById(Long id);


    Employee findByUsername(String username);
}
