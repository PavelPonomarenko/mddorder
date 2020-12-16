package ua.com.mddorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.mddorder.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    User findByEmail(String email);

//    void update(User user);
}
