package org.example.repository;

import org.example.model.Product;

import java.util.List;

public class FakeProductRepository implements Repository<Product>{

    @Override
    public void save(Product product) {
        System.out.println("Product saved to FakeRepository");
    }

    @Override
    public Product findById(int id) {
        return new Product(1, "dummy", 0.0);
    }

    @Override
    public List<Product> findAll() {
        return List.of(new Product(2, "dummy", 0.0), new Product(3, "dummy", 0.0));
    }

    @Override
    public void deleteById(int id) {
        System.out.println("Product deleted from FakeRepository");
    }
}
