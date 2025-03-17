/**
 * 矩形类 - 继承抽象类Shape并实现Drawable接口
 */
public class Rectangle extends Shape implements Drawable {
    private double width;   // 宽
    private double height;  // 高
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    // 实现Drawable接口的方法
    @Override
    public void draw() {
        System.out.println("画一个" + color + "的矩形，宽为" + width + "，高为" + height);
    }
} 