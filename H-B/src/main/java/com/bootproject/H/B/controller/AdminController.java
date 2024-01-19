package com.bootproject.H.B.controller;

import com.bootproject.H.B.dto.produtDTO;
import com.bootproject.H.B.model.Category;
import com.bootproject.H.B.service.CategoryService;
import com.bootproject.H.B.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model m) {
        m.addAttribute("categories", categoryService.getAllCategory());

        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getcatAdd(Model m) {
        m.addAttribute("category", new Category());

        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postcatAdd(@ModelAttribute("category") Category category) {

        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id) {
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {

            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else
            return "404";
    }


    //Product Section
    @GetMapping("admin/products")
    public String products(Model model) {
        model.addAttribute("products",productService.getAllProduct());

        return "products";

    }

    @GetMapping("admin/products/add")
    public String productsAddGet(Model model) {
        model.addAttribute("productDTO",new produtDTO());
model.addAttribute("categories", categoryService.getAllCategory());
        return "productsAdd";

    }
}
