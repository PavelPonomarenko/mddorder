package ua.com.mddorder.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.mddorder.model.BrandName;
import ua.com.mddorder.service.RootCrudService;

import java.util.List;

@RestController
@RequestMapping(path = "/auth/api/v1/admin/brand")
public class AdminRestBrandNameController {

    private final RootCrudService brandNameService;

    @Autowired
    public AdminRestBrandNameController(RootCrudService brandNameService) {
        this.brandNameService = brandNameService;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<BrandName>> getAllBrandNames() {
        List<BrandName> brandNameList = brandNameService.getAll();
        if (brandNameList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(brandNameList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BrandName> getUserById(@PathVariable(name = "id") Long id) {
        BrandName result = (BrandName) brandNameService.getOne(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
