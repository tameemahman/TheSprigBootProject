package com.bootproject.H.B.controller;


import com.bootproject.H.B.repository.ProductRepository;
import com.bootproject.H.B.service.CategoryService;
import com.bootproject.H.B.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
public  String home (){

    return "adminHome";
}

@Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping ({"/", "/home"})
    public String home(Model model){
        return "index";
    }

    @GetMapping ("/shop")
    public String shop(Model model){
       model.addAttribute("categories", categoryService.getAllCategory());
       model.addAttribute("products", productService.getAllProduct());
       return "shop";
    }
    @GetMapping ("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("categories", categoryService.getAllCategory());
//        model.addAttribute("products", productRepository.getByCategory(id));
        return "shop";
    }
    @GetMapping ("/shop/viewproduct/{id}")
    public String viewProduct (Model model, @PathVariable int id){
        model.addAttribute("product", productService.getproductById(id).get());

        return "viewProduct";
    }


}
