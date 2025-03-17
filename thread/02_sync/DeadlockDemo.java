/**
 * 死锁示例
 * 演示如何产生死锁以及如何避免
 */
public class DeadlockDemo {
    private static final Object RESOURCE_A = new Object();
    private static final Object RESOURCE_B = new Object();
    
    public static void main(String[] args) {
        // 创建线程1，先获取资源A，再获取资源B
        Thread t1 = new Thread(() -> {
            synchronized (RESOURCE_A) {
                System.out.println("线程1获取了资源A");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                System.out.println("线程1等待获取资源B");
                synchronized (RESOURCE_B) {
                    System.out.println("线程1获取了资源B");
                }
            }
        });
        
        // 创建线程2，先获取资源B，再获取资源A
        Thread t2 = new Thread(() -> {
            synchronized (RESOURCE_B) {
                System.out.println("线程2获取了资源B");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                System.out.println("线程2等待获取资源A");
                synchronized (RESOURCE_A) {
                    System.out.println("线程2获取了资源A");
                }
            }
        });
        
        // 启动线程
        t1.start();
        t2.start();
        
        // 避免死锁的方法：按照相同的顺序获取锁
        Thread t3 = new Thread(() -> {
            synchronized (RESOURCE_A) {
                System.out.println("线程3获取了资源A");
                synchronized (RESOURCE_B) {
                    System.out.println("线程3获取了资源B");
                }
            }
        });
        
        Thread t4 = new Thread(() -> {
            synchronized (RESOURCE_A) {
                System.out.println("线程4获取了资源A");
                synchronized (RESOURCE_B) {
                    System.out.println("线程4获取了资源B");
                }
            }
        });
    }
} 