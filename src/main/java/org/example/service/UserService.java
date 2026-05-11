package org.example.service;

import org.example.model.User;
import org.example.repository.Repository;

import java.util.List;

public class UserService {
    private Repository<User> userRepository;

    public UserService(Repository<User> userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addUser(User u){
        if (u == null){
            System.out.println("User cannot be null");
            return false;
        }
        if (userRepository.findById(u.getId()) != null) {
            System.out.println("User already exists");
            return false;
        }
        userRepository.save(u);
        System.out.println("User added successfully");
        return true;
    }

    public User getUserById(int id){
        return userRepository.findById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public boolean deleteUserById(int id){
        if(userRepository.findById(id) == null){
            System.out.println("User not found");
            return false;
        }
        userRepository.deleteById(id);
        System.out.println("User deleted successfully");
        return true;
    }
}
