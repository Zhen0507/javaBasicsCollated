/**
 * 线程同步示例
 * 演示synchronized关键字的使用
 */
public class SynchronizedDemo {
    private int count = 0;
    
    // 同步方法
    public synchronized void increment() {
        count++;
    }
    
    // 同步代码块
    public void incrementBlock() {
        synchronized(this) {
            count++;
        }
    }
    
    public int getCount() {
        return count;
    }
    
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo demo = new SynchronizedDemo();
        
        // 创建两个线程，各自增加计数器1000次
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment();
            }
        });
        
        // 启动线程
        t1.start();
        t2.start();
        
        // 等待两个线程执行完毕
        t1.join();
        t2.join();
        
        // 输出结果
        System.out.println("计数器最终值: " + demo.getCount());
    }
} 