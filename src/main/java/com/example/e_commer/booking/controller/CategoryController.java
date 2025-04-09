package com.example.e_commer.booking.controller;

import com.example.e_commer.booking.entity.Category;
import com.example.e_commer.booking.service.CategoryService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public Object create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @GetMapping
    public Object getListUser(){
        return categoryService.getListData();
    }

    @GetMapping("/{id}")
    public Object getDetailCategory(@PathVariable("id") Long id){
        return categoryService.getDataDetail(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleted(id);
    }

    @PutMapping
    public Object updateCategory(@RequestBody Category category){
        return categoryService.update(category);
    }
}
