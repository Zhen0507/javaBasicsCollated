/**
 * 继承示例 - 父类Person
 * 演示继承的基本概念
 */
public class Person {
    // 受保护的成员变量，允许子类访问
    protected String name;
    protected int age;

    // 构造方法
    public Person() {
        System.out.println("Person的无参构造方法被调用");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person的有参构造方法被调用");
    }

    // 公共方法
    public void eat() {
        System.out.println(name + "正在吃饭");
    }

    public void sleep() {
        System.out.println(name + "正在睡觉");
    }

    // 将被子类重写的方法
    public void introduce() {
        System.out.println("我是" + name + "，今年" + age + "岁");
    }
} 