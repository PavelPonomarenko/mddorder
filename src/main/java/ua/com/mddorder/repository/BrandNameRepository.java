package ua.com.mddorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.mddorder.model.BrandName;

@Repository
public interface BrandNameRepository extends JpaRepository<BrandName, Long> {

    @Override
    @Query("SELECT u FROM BrandName u WHERE u.id=?1")
    BrandName getOne(Long aLong);
}
