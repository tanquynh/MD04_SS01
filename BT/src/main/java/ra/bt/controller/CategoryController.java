package ra.bt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.bt.entity.Category;
import ra.bt.repository.CategoryRepository;

import java.util.List;
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "category/index";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/add")
    public String processAddCategory(@ModelAttribute("category") Category category) {
        if (category.getId() != null) {
            System.out.println("Cannot add new category with existing ID");
        } else {
            categoryRepository.save(category);
        }
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(Model model, @PathVariable("id") Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/edit/{id}")
    public String processEditCategory(@PathVariable("id") Long id, @ModelAttribute("category") Category category) {
        if (!categoryRepository.existsById(id)) {
            System.out.println("Category not found");
            return "redirect:/category";
        }

        category.setId(id); // Ensure the ID from path is set
        categoryRepository.save(category);
        return "redirect:/category";
    }
}
