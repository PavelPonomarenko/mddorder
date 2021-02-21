package ua.com.mddorder.service.adminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.mddorder.repository.CityRepository;
import ua.com.mddorder.service.CityService;
import ua.com.mddorder.model.City;

import java.util.List;
import java.util.Optional;

@Service
public class AdminCityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public AdminCityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {


        Optional<City> optional = cityRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalStateException("City with id " + id + " does not exists");
        }
        return cityRepository.getOne(id);


    }

    @Override
    public void deleteOne(Long id) {
        cityRepository.getOne(id);


    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void update(Long id, City city) {

    }
}
