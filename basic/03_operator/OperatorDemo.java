/**
 * Java运算符示例
 * 演示各种运算符的使用方法
 */
public class OperatorDemo {
    public static void main(String[] args) {
        // 1. 算术运算符
        int a = 10;
        int b = 3;
        System.out.println("加法：" + (a + b));    // 13
        System.out.println("减法：" + (a - b));    // 7
        System.out.println("乘法：" + (a * b));    // 30
        System.out.println("除法：" + (a / b));    // 3
        System.out.println("取余：" + (a % b));    // 1
        
        // 2. 自增自减运算符（符号在前先运算，符号在后后运算）
        int c = 5;                            // 步骤1：创建一个变量c，初始值为5
        System.out.println("自增前：" + (++c)); // 步骤2：先自增再使用值 → 6
        System.out.println("自增后：" + (c++)); // 步骤3：先使用值再自增 → 显示6（此时c=7）
        System.out.println("最终结果：" + c);   // 步骤4：显示最终结果 → 7
        
        // 3. 关系运算符
        System.out.println("大于：" + (a > b));    // true
        System.out.println("小于：" + (a < b));    // false
        System.out.println("等于：" + (a == b));   // false
        System.out.println("不等于：" + (a != b)); // true
        
        // 4. 逻辑运算符
        boolean x = true;
        boolean y = false;
        System.out.println("与：" + (x && y));     // false
        System.out.println("或：" + (x || y));     // true
        System.out.println("非：" + (!x));         // false
        
        // 5. 位运算符
        int m = 60;  // 二进制：0011 1100
        int n = 13;  // 二进制：0000 1101
        System.out.println("位与：" + (m & n));    // 12
        System.out.println("位或：" + (m | n));    // 61
        System.out.println("位异或：" + (m ^ n));  // 49
        
        // 6. 三元运算符
        int max = (a > b) ? a : b;
        System.out.println("最大值：" + max);      // 10
    }
} 