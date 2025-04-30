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

   // ✅ Update Product (simple version)
    public Product update(Product product) {
        return productRepository.save(product);
    }


    // ✅ Search Products
    public List<Product> searchByKeyword(String keyword) {
        return productRepository.searchByKeyword(keyword);
    }
}
