/**
 * 条件语句示例
 * 演示if语句的各种使用方式
 */
public class IfDemo {
    public static void main(String[] args) {
        // 1. 简单if语句
        int score = 85;
        if (score >= 60) {
            System.out.println("及格了！");
        }
        
        // 2. if-else语句
        int age = 20;
        if (age >= 18) {
            System.out.println("成年人");
        } else {
            System.out.println("未成年人");
        }
        
        // 3. if-else if-else语句
        int grade = 75;
        if (grade >= 90) {
            System.out.println("优秀");
        } else if (grade >= 80) {
            System.out.println("良好");
        } else if (grade >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }
        
        // 4. 嵌套if语句
        boolean hasTicket = true;
        boolean hasID = true;
        
        if (hasTicket) {
            System.out.println("有票，可以进站");
            
            if (hasID) {
                System.out.println("有身份证，可以乘车");
            } else {
                System.out.println("没有身份证，不能乘车");
            }
        } else {
            System.out.println("没票，不能进站");
        }
    }
} 