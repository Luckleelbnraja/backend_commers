package com.example.e_commer.booking.service;

import com.example.e_commer.booking.entity.Category;
import com.example.e_commer.booking.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
     private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Object create(Category category){
        return categoryRepository.save(category);
    }

    public Object getListData(){
        return categoryRepository.findAll();
    }

    public Object getDataDetail(Long id){
        return categoryRepository.findById(id).get();
    }

    public void deleted(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        category.ifPresent(categoryRepository::delete);
    }

    public Category update(Category category){
        // check di database if user exist
        // if exist then update
        // else throw error
        return null;
    }
}
