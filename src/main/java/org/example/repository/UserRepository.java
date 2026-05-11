package org.example.repository;

import org.example.model.Product;
import org.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRepository implements Repository<User>{

    private HashMap<Integer, User> userMap;

    public UserRepository() {
        this.userMap = new HashMap<>();
    }

    @Override
    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User findById(int id) {
        return userMap.get(id);
    }

    @Override
    public List findAll() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public void deleteById(int id) {
        userMap.remove(id);
    }
}
