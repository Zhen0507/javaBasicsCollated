/**
 * Spring Java配置示例
 * 演示使用Java代码配置Spring IoC容器
 */
public class JavaConfigDemo {
    public static void main(String[] args) {
        // 使用Java配置创建Spring IoC容器
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // 获取bean
        Student student = context.getBean(Student.class);
        System.out.println("学生信息：");
        System.out.println("姓名：" + student.getName());
        System.out.println("年龄：" + student.getAge());
        
        // 获取另一个bean
        Teacher teacher = context.getBean(Teacher.class);
        System.out.println("\n教师信息：");
        System.out.println("姓名：" + teacher.getName());
        System.out.println("科目：" + teacher.getSubject());
        
        // 关闭容器
        ((AnnotationConfigApplicationContext) context).close();
    }
} 