/**
 * Java基本数据类型演示
 * 包含所有基本数据类型的定义和使用
 */
public class DataTypeDemo {
    public static void main(String[] args) {
        // 1. 整数类型
        byte b = 127;                  // 占1个字节 范围：-128~127
        short s = 32767;               // 占2个字节 范围：-32768~32767
        int i = 2147483647;            // 占4个字节 范围：-2^31~2^31-1
        long l = 9223372036854775807L; // 占8个字节 范围：-2^63~2^63-1
        
        // 2. 浮点类型
        float f = 3.14f;               // 占4个字节 单精度浮点
        double d = 3.141592653589793;  // 占8个字节 双精度浮点
        
        // 3. 字符类型
        char c1 = 'A';                 // 字符型 占2个字节
        char c2 = '中';                // 可以存储一个汉字
        
        // 4. 布尔类型
        boolean flag1 = true;          // 占1个字节
        boolean flag2 = false;
        
        // 输出各种数据类型的值
        System.out.println("byte类型：" + b);
        System.out.println("short类型：" + s);
        System.out.println("int类型：" + i);
        System.out.println("long类型：" + l);
        System.out.println("float类型：" + f);
        System.out.println("double类型：" + d);
        System.out.println("char类型：" + c1 + ", " + c2);
        System.out.println("boolean类型：" + flag1 + ", " + flag2);
        
        // 类型转换示例
        int x = (int)3.14;            // 强制类型转换
        double y = 10;                // 自动类型转换
        System.out.println("强制类型转换：" + x);
        System.out.println("自动类型转换：" + y);
    }
} 