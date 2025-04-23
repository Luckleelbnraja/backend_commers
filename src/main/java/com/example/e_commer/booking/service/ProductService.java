package com.example.e_commer.booking.service;

import com.example.e_commer.booking.entity.Category;
import com.example.e_commer.booking.entity.Product;
import com.example.e_commer.booking.repository.CategoryRepository;
import com.example.e_commer.booking.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getListData() {
        return productRepository.findAll();
    }

    public Product getDataDetail(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " not found"));
    }

    public void deleted(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID " + id + " not found"));
        productRepository.delete(product);
    }

    public Product update(Product product) {
        Product existingProduct = productRepository.findById(product.getId())
            .orElseThrow(() -> new RuntimeException("Produk tidak ditemukan"));
    
        existingProduct.setName(product.getName());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setImageUrl(product.getImageUrl());
    
        // ✅ Tambahan pengecekan supaya aman
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Kategori tidak ditemukan"));
            existingProduct.setCategory(category);
        }
    
        return productRepository.save(existingProduct);
    }
}
