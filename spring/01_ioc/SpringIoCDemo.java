/**
 * Spring IoC示例
 * 演示Spring IoC容器的基本使用
 */
public class SpringIoCDemo {
    public static void main(String[] args) {
        // 创建Spring IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // 从容器中获取bean
        Student student = (Student) context.getBean("student");
        
        // 使用bean
        System.out.println("学生信息：");
        System.out.println("姓名：" + student.getName());
        System.out.println("年龄：" + student.getAge());
        
        // 获取另一个bean
        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println("\n教师信息：");
        System.out.println("姓名：" + teacher.getName());
        System.out.println("科目：" + teacher.getSubject());
        
        // 关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }
} 