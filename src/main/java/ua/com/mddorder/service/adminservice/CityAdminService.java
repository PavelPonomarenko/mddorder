package ua.com.mddorder.service.adminservice;

import ua.com.mddorder.model.City;

import java.util.List;

public interface CityAdminService {

    List getAll();

    City findById(Long id);

    void deleteOne(Long id);

    City save(City city);

    void update(Long id, City city);

}
