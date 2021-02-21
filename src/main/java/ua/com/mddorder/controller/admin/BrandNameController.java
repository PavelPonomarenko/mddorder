package ua.com.mddorder.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.mddorder.model.BrandName;
import ua.com.mddorder.service.BrandNameService;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/admin/super/controller/brand")
public class BrandNameController {

    private final BrandNameService brandNameService;

    //    @Autowired
    public BrandNameController(BrandNameService brandNameService) {
        this.brandNameService = brandNameService;
    }

    @GetMapping("/")
    public String getBrandNamePage(BrandName brandName, Model model) {
        model.addAttribute("brandNames", brandNameService.getAll());
        return "brand-name-form";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("brandName") BrandName brandName) {
        brandNameService.save(brandName);
        return "brand-name-form";
    }


    @GetMapping("/all")
    public String getAll(Model model) {
        List<BrandName> list = brandNameService.getAll();
        model.addAttribute("brandNames", list);
        return "brand-name-form";
    }


}
