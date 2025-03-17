/**
 * 继承示例 - 子类Teacher
 * 演示多态的使用
 */
public class Teacher extends Person {
    private String subject;   // 教授科目
    
    public Teacher() {
        super();
        System.out.println("Teacher的无参构造方法被调用");
    }
    
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
        System.out.println("Teacher的有参构造方法被调用");
    }
    
    // getter和setter
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Override
    public void introduce() {
        super.introduce();
        System.out.println("我教授的科目是：" + subject);
    }
    
    // 教师特有方法
    public void teach() {
        System.out.println(name + "正在教授" + subject);
    }
} 