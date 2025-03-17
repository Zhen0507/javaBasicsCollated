package com.example.service;

import org.springframework.stereotype.Service;
import com.example.model.User;
import com.example.repository.UserRepository;
import java.util.List;

/**
 * 用户服务类
 */
@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    // 使用构造函数注入 - Spring推荐的方式
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User save(User user) {
        return userRepository.save(user);
    }
    
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
    
    public List<User> findByAgeGreaterThan(int age) {
        return userRepository.findByAgeGreaterThan(age);
    }
} 