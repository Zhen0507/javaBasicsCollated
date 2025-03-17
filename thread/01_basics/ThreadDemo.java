/**
 * 线程基础示例
 * 演示创建线程的两种方式
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 方式一：继承Thread类
        MyThread thread1 = new MyThread("Thread-1");
        thread1.start();  // 启动线程
        
        // 方式二：实现Runnable接口
        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable, "Thread-2");
        thread2.start();
        
        // 主线程
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程: " + i);
            try {
                Thread.sleep(100);  // 休眠100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 方式一：继承Thread类
 */
class MyThread extends Thread {
    public MyThread(String name) {
        super(name);  // 设置线程名称
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 方式二：实现Runnable接口
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
} 