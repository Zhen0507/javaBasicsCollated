import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池示例
 * 演示Java内置的线程池
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建固定大小的线程池
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        
        // 提交任务
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            fixedPool.execute(() -> {
                System.out.println("任务" + taskId + "开始执行，线程：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);  // 模拟耗时操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务" + taskId + "执行完成");
            });
        }
        
        // 关闭线程池
        fixedPool.shutdown();
        
        // 创建可缓存的线程池
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        
        // 创建单线程的线程池
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        
        // 创建定时任务的线程池
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        
        // 延迟执行任务
        scheduledPool.schedule(() -> {
            System.out.println("延迟3秒执行");
        }, 3, TimeUnit.SECONDS);
        
        // 定期执行任务
        scheduledPool.scheduleAtFixedRate(() -> {
            System.out.println("每2秒执行一次");
        }, 0, 2, TimeUnit.SECONDS);
        
        // 不要忘记关闭线程池
        // scheduledPool.shutdown();
    }
} 