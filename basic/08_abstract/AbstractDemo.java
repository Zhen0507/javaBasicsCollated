/**
 * 抽象类和接口使用示例
 */
public class AbstractDemo {
    public static void main(String[] args) {
        // 创建具体对象
        Circle circle = new Circle("红色", 5.0);
        Rectangle rectangle = new Rectangle("蓝色", 4.0, 6.0);
        
        // 使用抽象类方法
        System.out.println("===图形计算===");
        System.out.println("圆形面积：" + circle.getArea());
        System.out.println("圆形周长：" + circle.getPerimeter());
        System.out.println("矩形面积：" + rectangle.getArea());
        System.out.println("矩形周长：" + rectangle.getPerimeter());
        
        // 使用接口方法
        System.out.println("\n===绘图操作===");
        circle.prepare();      // 默认方法
        circle.draw();        // 实现的抽象方法
        Drawable.clean();     // 静态方法
    }
} 