package ra.bt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.bt.entity.Product;
import ra.bt.service.CategoryService;
import ra.bt.service.ProductService;

import java.util.List;
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String getAllProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/index";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "product/add";}

    @PostMapping("/add")
    public String processAddProduct(@ModelAttribute("product") Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/product";
    }

    // Endpoint to display the form for editing a product by ID
    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "product/edit"; // Assuming the Thymeleaf template name is "edit.html"
    }

    // Endpoint to handle the form submission for editing a product
    @PostMapping("/edit/{id}")
    public String processEditProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/product"; // Redirect to a page showing all products
    }

    // Endpoint to delete a product by ID
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        productService.delete(product);
        return "redirect:/product";
    }
}


