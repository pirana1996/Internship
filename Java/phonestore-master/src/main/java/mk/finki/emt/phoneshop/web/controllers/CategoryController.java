package mk.finki.emt.phoneshop.web.controllers;

import mk.finki.emt.phoneshop.config.Layout;
import mk.finki.emt.phoneshop.model.Category;
import mk.finki.emt.phoneshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Layout("layout/master")
    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("category", new Category());
        return "forms/category.Add";
    }

    @Layout("layout/master")
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        categoryService.save(category);
        return "common/success";
    }
}
