/**
 * switch语句示例
 * 演示switch语句的基本用法
 */
public class SwitchDemo {
    public static void main(String[] args) {
        // 1. 基本switch语句
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("无效日期");
        }
        
        // 2. 不使用break的情况
        int month = 8;
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            default:
                System.out.println("无效月份");
        }
        
        // 3. 字符串类型的switch (Java 7及以上版本支持)
        String fruit = "apple";
        switch (fruit) {
            case "apple":
                System.out.println("这是苹果");
                break;
            case "banana":
                System.out.println("这是香蕉");
                break;
            case "orange":
                System.out.println("这是橙子");
                break;
            default:
                System.out.println("未知水果");
        }
        
        // 4. 枚举类型的switch
        Season season = Season.SUMMER;
        switch (season) {
            case SPRING:
                System.out.println("春暖花开");
                break;
            case SUMMER:
                System.out.println("夏日炎炎");
                break;
            case AUTUMN:
                System.out.println("秋高气爽");
                break;
            case WINTER:
                System.out.println("冬雪皑皑");
                break;
        }
    }
    
    // 枚举类型
    enum Season {
        SPRING, SUMMER, AUTUMN, WINTER
    }
} 