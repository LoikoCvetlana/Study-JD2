package com.sportoras.web.controller;

import com.sportoras.database.entity.Product;
import com.sportoras.service.dto.ProductFullDto;
import com.sportoras.service.service.ProductService;
import com.sportoras.web.utilit.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/product-info")
    public String productInfo(Model model, Long productId) {
        Product product = productService.findProductById(productId);
        model.addAttribute("product", product);
        return "/product-info";
    }
}
