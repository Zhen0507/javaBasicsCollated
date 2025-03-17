/**
 * 锁机制示例
 * 演示ReentrantLock的使用
 */
public class LockDemo {
    private final Lock lock = new ReentrantLock();
    private int count = 0;
    
    public void increment() {
        lock.lock();  // 获取锁
        try {
            count++;
        } finally {
            lock.unlock();  // 释放锁
        }
    }
    
    public int getCount() {
        return count;
    }
    
    public static void main(String[] args) throws InterruptedException {
        LockDemo demo = new LockDemo();
        
        // 创建多个线程
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    demo.increment();
                }
            });
            threads[i].start();
        }
        
        // 等待所有线程完成
        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("最终计数: " + demo.getCount());
        
        // 尝试获取锁
        Lock tryLock = new ReentrantLock();
        if (tryLock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                System.out.println("获取到锁");
            } finally {
                tryLock.unlock();
            }
        } else {
            System.out.println("未能获取到锁");
        }
        
        // 读写锁
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock readLock = rwLock.readLock();
        Lock writeLock = rwLock.writeLock();
        
        // 多个线程可以同时获取读锁
        readLock.lock();
        // 读取操作
        readLock.unlock();
        
        // 写锁是排他的
        writeLock.lock();
        // 写入操作
        writeLock.unlock();
    }
} 