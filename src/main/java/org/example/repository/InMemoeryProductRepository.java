package org.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.example.model.Product;

public class InMemoeryProductRepository  implements Repository<Product>{

    private HashMap<Integer, Product> productMap;

    public InMemoeryProductRepository() {
        this.productMap = new HashMap<>();
    }

//    private HashMap<Integer, Product> productMap;
//
//    public InMemoeryProductRepository() {
//        this.productMap = new HashMap<>();
//    }

  @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

  @Override
  public Product findById(int id) {
    return productMap.get(id);
  }

  @Override
  public List<Product> findAll() {
    return new ArrayList<>(productMap.values());
  }

  @Override
  public void deleteById(int id) {
    productMap.remove(id);
  }


}
