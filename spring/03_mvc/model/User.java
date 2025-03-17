package com.example.model;

/**
 * 用户实体类
 */
public class User {
    private String username;
    private String email;
    private int age;
    
    // 无参构造函数
    public User() {
    }
    
    // 有参构造函数
    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
    
    // getter和setter
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
} 