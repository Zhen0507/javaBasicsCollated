/**
 * 接口示例
 * 演示接口的定义和使用
 */
public interface Drawable {
    // 常量定义
    String TOOL = "画笔";
    
    // 抽象方法
    void draw();
    
    // 默认方法
    default void prepare() {
        System.out.println("准备" + TOOL);
    }
    
    // 静态方法
    static void clean() {
        System.out.println("清理画具");
    }
} 