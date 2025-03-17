/**
 * 多态示例
 * 演示多态的实际应用
 */
public class PolymorphismDemo {
    public static void main(String[] args) {
        // 创建不同对象
        Person person = new Person("张三", 30);
        Student student = new Student("李四", 18, "2024001");
        Teacher teacher = new Teacher("王五", 35, "数学");

        // 多态使用示例
        Person p1 = new Student("赵六", 20, "2024002");
        Person p2 = new Teacher("钱七", 40, "英语");

        // 调用同一个方法会表现出不同行为
        System.out.println("===多态示例===");
        person.introduce();
        p1.introduce();
        p2.introduce();

        // 类型转换示例
        if (p1 instanceof Student) {
            Student s = (Student) p1;    // 向下转型
            s.study();                   // 调用子类特有方法
        }

        // 数组多态
        Person[] people = new Person[3];
        people[0] = person;
        people[1] = student;
        people[2] = teacher;

        // 遍历调用
        System.out.println("\n===遍历数组===");
        for (Person p : people) {
            p.introduce();
        }
    }
}