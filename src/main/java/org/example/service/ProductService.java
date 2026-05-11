package org.example.service;

import org.example.model.Product;
import org.example.repository.InMemoeryProductRepository;
import org.example.repository.Repository;

import java.util.List;

public class ProductService {

    private Repository<Product> productRepository;

    public ProductService(Repository<Product> productRepository){
        this.productRepository = productRepository;
    }
//    private InMemoeryProductRepository productRepository;
//
//    public ProductService(InMemoeryProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public boolean addProduct(Product p) {
        if (p == null) {
            System.out.println("Product cannot be null");
            return false;
        }
        if(productRepository.findById(p.getId()) != null) {
            System.out.println("Product already exists");
            return false;
        }
        productRepository.save(p);
        System.out.println("Product added successfully");
        return true;
    }

    public Product getProductById(int id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public boolean removeProduct(int id) {
        if (getProductById(id) == null) {
            System.out.println("Product not found");
            return false;
        }
      productRepository.deleteById(id);
        System.out.println("Product deleted successfully");
        return true;
    }
}
