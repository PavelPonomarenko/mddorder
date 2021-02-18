package ua.com.mddorder.service;

import ua.com.mddorder.model.BrandName;

import java.util.List;

public interface BrandNameService {

    void delete(Long id);

    BrandName addNewBrandName(BrandName brandName);

    List getAll();

    BrandName findById(Long id);

    void deleteOne(Long id);

    BrandName save(BrandName brandName);

    void update(Long id, BrandName brandName);


}
