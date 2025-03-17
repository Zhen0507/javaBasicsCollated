/**
 * 线程生命周期示例
 * 演示线程的状态和常用方法
 */
public class ThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread thread = new Thread(() -> {
            System.out.println("线程开始运行");
            try {
                Thread.sleep(2000);  // 休眠2秒
                System.out.println("线程休眠结束");
            } catch (InterruptedException e) {
                System.out.println("线程被中断");
                return;  // 结束线程
            }
            
            // 模拟耗时操作
            for (int i = 0; i < 5; i++) {
                System.out.println("线程执行中: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println("线程执行完毕");
        });
        
        // 获取线程状态
        System.out.println("初始状态: " + thread.getState());
        
        // 启动线程
        thread.start();
        System.out.println("启动后状态: " + thread.getState());
        
        // 等待一段时间
        Thread.sleep(1000);
        System.out.println("休眠中状态: " + thread.getState());
        
        // 等待线程结束
        thread.join();
        System.out.println("结束后状态: " + thread.getState());
        
        // 线程优先级
        Thread highPriority = new Thread(() -> {
            System.out.println("高优先级线程");
        });
        Thread lowPriority = new Thread(() -> {
            System.out.println("低优先级线程");
        });
        
        highPriority.setPriority(Thread.MAX_PRIORITY);  // 10
        lowPriority.setPriority(Thread.MIN_PRIORITY);   // 1
        
        highPriority.start();
        lowPriority.start();
    }
} 