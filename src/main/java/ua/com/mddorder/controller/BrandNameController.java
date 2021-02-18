package ua.com.mddorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.mddorder.model.BrandName;
import ua.com.mddorder.service.BrandNameService;

@Controller
@RequestMapping(path = "/api/v1/superadmin/")
public class BrandNameController {

    private final BrandNameService brandNameService;

//    @Autowired
    public BrandNameController(BrandNameService brandNameService) {
        this.brandNameService = brandNameService;
    }

    @PostMapping("brand/create")
    public String save(@ModelAttribute("brandName") BrandName brandName) {
        brandNameService.save(brandName);
        return "brand-name";
    }

}
