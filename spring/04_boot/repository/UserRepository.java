package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.User;
import java.util.List;

/**
 * 用户数据访问接口
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
    // 根据用户名查找
    User findByUsername(String username);
    
    // 根据邮箱查找
    User findByEmail(String email);
    
    // 查找年龄大于指定值的用户
    List<User> findByAgeGreaterThan(int age);
} 