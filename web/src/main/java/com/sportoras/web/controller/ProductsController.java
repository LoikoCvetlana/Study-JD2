package com.sportoras.web.controller;

import com.sportoras.database.entity.Material;
import com.sportoras.database.entity.Product;
import com.sportoras.service.dto.productDto.ProductBasicDto;
import com.sportoras.service.dto.productDto.ProductCreateDto;
import com.sportoras.service.dto.productDto.ProductDtoFilter;
import com.sportoras.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<ProductBasicDto> products = productService.allProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/product-info")
    public String productInfo(Model model, Long id) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "/product-info";
    }

    @GetMapping("/product-save")
    public String openProductSave(Model model) {
        model.addAttribute("productCreateDto", new ProductCreateDto());
        return "/product-save";
    }

    @PostMapping("/product-save")
    public String saveNewProduct(ProductCreateDto productCreateDto) {
        productService.saveProduct(productCreateDto);
        return "redirect:/products";
    }

//    @GetMapping("/product-filter")
//    // TODO: 30.11.2018
//    public String openProductFilter(Model model) {
//        model.addAttribute("productDtoFilter", new ProductDtoFilter());
//        return "/products";
//    }

//    @PostMapping("/product-filter")
//    public String filteredProducts(ProductDtoFilter productDtoFilter) {
//        List<ProductBasicDto> products = productService.filterProduct(productDtoFilter);
//        return "/products";
//    }
}
