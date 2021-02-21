package ua.com.mddorder.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.mddorder.model.City;
import ua.com.mddorder.service.CityService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/admin/super/city")
public class AdminCityRestController {

    private final CityService cityService;

    @Autowired
    public AdminCityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<City>> getAll() {
        List<City> cityList = cityService.getAll();
        if (cityList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> getUserById(@PathVariable(name = "id") Long id) {
        City result = cityService.findById(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
//
//    @PostMapping(path = "/create")
//    public ResponseEntity<City> save(@RequestBody City city) {
//
//        City result = cityService.add(city);
//        if (result == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(result, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping(path = "/delete/{id}")
//    public void delete(@PathVariable("id") Long cityId) {
//        cityService.deleteOne(cityId);
//    }

}
