/**
 * 圆形类 - 继承抽象类Shape并实现Drawable接口
 */
public class Circle extends Shape implements Drawable {
    private double radius;  // 半径
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    // 实现Drawable接口的方法
    @Override
    public void draw() {
        System.out.println("画一个" + color + "的圆，半径为" + radius);
    }
} 