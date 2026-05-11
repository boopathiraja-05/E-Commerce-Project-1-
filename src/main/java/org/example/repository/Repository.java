package org.example.repository;

import org.example.model.Product;

import java.util.List;

public interface Repository<T>{
    public void save(T t);
    public T findById(int id);
    public List<T> findAll();
    public void deleteById(int id);


}
