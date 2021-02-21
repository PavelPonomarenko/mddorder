package ua.com.mddorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.mddorder.model.BrandName;

@Repository
public interface BrandNameRepository extends JpaRepository<BrandName, Long> {

    @Override
    @Query("SELECT u FROM BrandName u WHERE u.id=?1")
    BrandName getOne(Long aLong);


//    @Transactional
    @Modifying
    @Query("DELETE FROM BrandName u WHERE u.id=?1")
    void deleteOne(@Param("id") Long id);
}
