import java.io.Serializable;

/**
 * 可序列化的学生类
 */
public class Student implements Serializable {
    // 序列化版本号
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;
    private String studentId;
    
    // transient修饰的字段不会被序列化
    private transient String password = "123456";
    
    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + 
               ", studentId='" + studentId + "', password='" + password + "'}";
    }
} 