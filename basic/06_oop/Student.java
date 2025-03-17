///**
// * 面向对象基础示例 - 学生类
// * 演示类的定义、属性、方法、构造器等概念
// */
//public class Student {
//    // 成员变量（属性）
//    private String name;    // 姓名
//    private int age;       // 年龄
//    private String grade;  // 年级
//
//    // 构造方法
//    public Student() {
//        // 无参构造器
//        System.out.println("创建了一个学生对象");
//    }
//
//    public Student(String name, int age, String grade) {
//        this.name = name;
//        this.age = age;
//        this.grade = grade;
//        System.out.println("创建了学生：" + name);
//    }
//
//    // getter和setter方法
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        if (age > 0 && age < 120) {
//            this.age = age;
//        } else {
//            System.out.println("年龄不合法");
//        }
//    }
//
//    public String getGrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }
//
//    // 成员方法
//    public void study() {
//        System.out.println(name + "正在学习...");
//    }
//
//    public void showInfo() {
//        System.out.println("学生信息：");
//        System.out.println("姓名：" + name);
//        System.out.println("年龄：" + age);
//        System.out.println("年级：" + grade);
//    }
//
//    // 静态方法
//    public static void staticMethod() {
//        System.out.println("这是一个静态方法");
//    }
//
//    // 主方法，用于测试
//    public static void main(String[] args) {
//        // 创建对象
//        Student s1 = new Student();
//        s1.setName("张三");
//        s1.setAge(20);
//        s1.setGrade("大一");
//
//        // 调用方法
//        s1.showInfo();
//        s1.study();
//
//        // 创建对象并初始化
//        Student s2 = new Student("李四", 22, "大二");
//        s2.showInfo();
//
//        // 调用静态方法
//        Student.staticMethod();
//    }
//}