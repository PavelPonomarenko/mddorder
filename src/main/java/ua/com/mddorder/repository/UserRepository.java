package ua.com.mddorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.mddorder.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String name);
}
