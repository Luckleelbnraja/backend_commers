package com.example.e_commer.booking.controller;

import com.example.e_commer.booking.entity.Product;
import com.example.e_commer.booking.service.ProductService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public Object create(@RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping
    public Object getListProduct(){
        return productService.getListData();
    }

    @GetMapping("/{id}")
    public Object getDetailProduct(@PathVariable("id") Long id){
        return productService.getDataDetail(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleted(id);
    }

    @PutMapping
    public Object updateProduct(@RequestBody Product product){
        return productService.update(product);
    }
}
