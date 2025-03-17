import java.io.*;

/**
 * 序列化示例
 * 演示对象的序列化和反序列化
 */
public class SerializationDemo {
    public static void main(String[] args) {
        // 创建对象
        Student student = new Student("张三", 20, "2024001");
        
        // 序列化对象到文件
        try (ObjectOutputStream oos = 
             new ObjectOutputStream(new FileOutputStream("student.dat"))) {
            oos.writeObject(student);
            System.out.println("对象已序列化到文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 从文件反序列化对象
        try (ObjectInputStream ois = 
             new ObjectInputStream(new FileInputStream("student.dat"))) {
            Student s = (Student) ois.readObject();
            System.out.println("反序列化的对象: " + s);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 可序列化的学生类
 */
class Student implements Serializable {
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