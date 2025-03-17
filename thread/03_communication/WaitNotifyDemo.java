/**
 * 线程通信示例
 * 演示wait/notify机制
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {
        // 共享对象
        final Object lock = new Object();
        
        // 生产者线程
        Thread producer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("生产者开始生产");
                try {
                    Thread.sleep(1000);  // 模拟生产过程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                System.out.println("生产完成，通知消费者");
                lock.notify();  // 通知等待的消费者
            }
        });
        
        // 消费者线程
        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("消费者等待产品");
                try {
                    lock.wait();  // 等待生产者通知
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                System.out.println("收到通知，开始消费");
            }
        });
        
        // 启动线程
        consumer.start();  // 先启动消费者
        try {
            Thread.sleep(100);  // 确保消费者先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.start();  // 再启动生产者
    }
} 