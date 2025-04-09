package com.example.e_commer.booking.service;

import com.example.e_commer.booking.entity.Product;
import com.example.e_commer.booking.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Object create(Product product){
        return productRepository.save(product);
    }

    public Object getListData(){
        return productRepository.findAll();
    }

    public Object getDataDetail(Long id){
        return productRepository.findById(id).get();
    }

    public void deleted(Long id){
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(productRepository::delete);
    }

    public Product update(Product product){
        // check di database if user exist
        // if exist then update
        // else throw error
        return null;
    }
}
