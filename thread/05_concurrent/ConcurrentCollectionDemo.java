import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 并发集合示例
 * 演示Java并发包中的集合类
 */
public class ConcurrentCollectionDemo {
    public static void main(String[] args) {
        // 线程安全的ArrayList
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        
        // ConcurrentHashMap
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        
        // 多线程环境下使用
        for (int i = 0; i < 10; i++) {
            concurrentMap.put("key" + i, i);
        }
        
        // 并发修改
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                concurrentMap.put("thread1-" + i, i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
        // 并发遍历
        new Thread(() -> {
            for (Map.Entry<String, Integer> entry : concurrentMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
        // CopyOnWriteArrayList - 适用于读多写少的场景
        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        copyOnWriteList.add("A");
        copyOnWriteList.add("B");
        
        // 并发队列
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        
        // 生产者
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    blockingQueue.put("Item " + i);
                    System.out.println("生产: Item " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
        // 消费者
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    String item = blockingQueue.take();
                    System.out.println("消费: " + item);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
} 