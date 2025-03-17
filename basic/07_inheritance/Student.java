/**
 * 继承示例 - 子类Student
 * 演示方法重写和super关键字的使用
 */
public class Student extends Person {
    private String studentId;  // 学号

    public Student() {
        super();  // 调用父类无参构造方法
        System.out.println("Student的无参构造方法被调用");
    }

    public Student(String name, int age, String studentId) {
        super(name, age);     // 调用父类有参构造方法
        this.studentId = studentId;
        System.out.println("Student的有参构造方法被调用");
    }

    // getter和setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // 方法重写
    @Override
    public void introduce() {
        super.introduce();    // 调用父类方法
        System.out.println("我的学号是：" + studentId);
    }

    // 子类特有方法
    public void study() {
        System.out.println(name + "正在学习");
    }
}