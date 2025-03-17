package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.model.Student;
import com.example.model.Teacher;

/**
 * Spring Java配置类
 */
@Configuration
public class AppConfig {
    
    @Bean
    public Student student() {
        Student student = new Student();
        student.setName("李四");
        student.setAge(22);
        return student;
    }
    
    @Bean
    public Teacher teacher() {
        Teacher teacher = new Teacher();
        teacher.setName("赵老师");
        teacher.setSubject("英语");
        return teacher;
    }
} 