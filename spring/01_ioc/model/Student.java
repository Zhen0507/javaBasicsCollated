package com.example.model;

/**
 * 学生实体类
 */
public class Student {
    private String name;
    private int age;
    
    // 无参构造函数
    public Student() {
        System.out.println("Student对象被创建");
    }
    
    // 有参构造函数
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student对象被创建，参数：" + name + ", " + age);
    }
    
    // getter和setter
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    // 初始化方法
    public void init() {
        System.out.println("Student对象初始化");
    }
    
    // 销毁方法
    public void destroy() {
        System.out.println("Student对象销毁");
    }
} 