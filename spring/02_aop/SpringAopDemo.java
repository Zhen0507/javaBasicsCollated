/**
 * Spring AOP示例
 * 演示Spring AOP的基本使用
 */
public class SpringAopDemo {
    public static void main(String[] args) {
        // 创建Spring IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("aop-context.xml");
        
        // 获取bean
        Calculator calculator = context.getBean("calculator", Calculator.class);
        
        // 调用方法，将触发AOP
        System.out.println("10 + 5 = " + calculator.add(10, 5));
        System.out.println("10 - 5 = " + calculator.subtract(10, 5));
        
        try {
            System.out.println("10 / 0 = " + calculator.divide(10, 0));
        } catch (Exception e) {
            System.out.println("捕获异常：" + e.getMessage());
        }
        
        // 关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }
} 