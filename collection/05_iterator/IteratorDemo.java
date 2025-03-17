import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 迭代器示例
 * 演示Iterator和增强for循环的使用
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("JavaScript");
        
        // 使用Iterator遍历
        System.out.println("===使用Iterator遍历===");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if (element.equals("Python")) {
                iterator.remove();  // 安全删除元素
            }
        }
        System.out.println("删除元素后的列表: " + list);
        
        // 使用增强for循环
        System.out.println("\n===使用增强for循环===");
        for (String element : list) {
            System.out.println(element);
            // 注意：不能在增强for循环中修改集合结构
            // 如果尝试在这里删除元素，会抛出ConcurrentModificationException
        }
        
        // 使用forEach方法（Java 8+）
        System.out.println("\n===使用forEach方法===");
        list.forEach(element -> System.out.println(element));
        
        // 方法引用（Java 8+）
        System.out.println("\n===使用方法引用===");
        list.forEach(System.out::println);
        
        // 遍历Map
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);
        
        // 使用entrySet和Iterator
        System.out.println("\n===使用entrySet和Iterator遍历Map===");
        Iterator<Map.Entry<String, Integer>> mapIterator = map.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, Integer> entry = mapIterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 使用增强for循环遍历Map
        System.out.println("\n===使用增强for循环遍历Map===");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 使用forEach遍历Map（Java 8+）
        System.out.println("\n===使用forEach遍历Map===");
        map.forEach((key, value) -> System.out.println(key + ": " + value));
        
        // 迭代器的局限性
        System.out.println("\n===迭代器的局限性===");
        Collection<String> collection = new ArrayList<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        
        Iterator<String> it = collection.iterator();
        System.out.println("第一个元素: " + it.next());
        collection.add("D");  // 在迭代过程中修改集合
        try {
            System.out.println("下一个元素: " + it.next());  // 可能抛出ConcurrentModificationException
        } catch (Exception e) {
            System.out.println("发生异常: " + e.getClass().getName());
            System.out.println("在迭代过程中修改集合会导致异常");
        }
    }
} 