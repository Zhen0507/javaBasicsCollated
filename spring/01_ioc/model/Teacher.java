package com.example.model;

/**
 * 教师实体类
 */
public class Teacher {
    private String name;
    private String subject;
    
    // 无参构造函数
    public Teacher() {
        System.out.println("Teacher对象被创建");
    }
    
    // getter和setter
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
} 