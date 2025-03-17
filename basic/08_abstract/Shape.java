/**
 * 抽象类示例
 * 演示抽象类的定义和使用
 */
public abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // 抽象方法 - 计算面积
    public abstract double getArea();
    
    // 抽象方法 - 计算周长
    public abstract double getPerimeter();
    
    // 具体方法
    public void display() {
        System.out.println("这是一个" + color + "的图形");
    }
} 