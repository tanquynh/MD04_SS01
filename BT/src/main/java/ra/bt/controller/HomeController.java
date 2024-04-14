package ra.bt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ra.bt.service.CategoryService;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String home() {
        return "home";
    }
}
