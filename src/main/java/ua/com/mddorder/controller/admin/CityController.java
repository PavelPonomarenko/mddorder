package ua.com.mddorder.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.mddorder.model.City;
import ua.com.mddorder.service.CityService;

@Controller
@RequestMapping(path = "/api/v1/admin/super/controller/city")
public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getBrandNamePage(City city, Model model) {
        model.addAttribute("cities", service.getAll());
        return "cities-form";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("city") City city) {
        service.save(city);
        return "cities-form";
    }
}
