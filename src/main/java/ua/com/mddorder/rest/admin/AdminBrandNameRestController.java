package ua.com.mddorder.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.mddorder.model.BrandName;
import ua.com.mddorder.service.BrandNameService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/admin/super/brandnames")
public class AdminBrandNameRestController {

    private final BrandNameService brandNameService;

    @Autowired
    public AdminBrandNameRestController(BrandNameService brandNameService) {
        this.brandNameService = brandNameService;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<BrandName>> getAll() {
        List<BrandName> brandNameList = brandNameService.getAll();
        if (brandNameList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(brandNameList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BrandName> getUserById(@PathVariable(name = "id") Long id) {
        BrandName result = brandNameService.findById(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") Long brandNameId) {
        brandNameService.deleteOne(brandNameId);
    }


    @PostMapping(path = "/add")
    public void registerNewUser(@RequestBody BrandName brandName) {
        brandNameService.save(brandName);
    }


//    @PostMapping(path = "user/add")
//    public void registerNewUser(@RequestBody User user) {
//        userService.addNewUser(user);
//    }
//
//    @PutMapping(path = "user/update/{id}")
//    public void update(@PathVariable Long id,
//                       @RequestParam(required = false) String username,
//                       @RequestParam(required = false) String email) {
//        userService.update(id, username, email);
//    }
}
