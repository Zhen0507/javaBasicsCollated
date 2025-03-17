import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map接口示例
 * 演示HashMap、LinkedHashMap和TreeMap的使用
 */
public class MapDemo {
    public static void main(String[] args) {
        // HashMap示例
        Map<String, Integer> hashMap = new HashMap<>();
        
        // 添加键值对
        hashMap.put("张三", 95);
        hashMap.put("李四", 88);
        hashMap.put("王五", 92);
        System.out.println("HashMap: " + hashMap);  // 无序
        
        // 获取值
        System.out.println("张三的分数：" + hashMap.get("张三"));
        
        // 检查键是否存在
        System.out.println("是否包含'李四'：" + hashMap.containsKey("李四"));
        System.out.println("是否包含分数90：" + hashMap.containsValue(90));
        
        // 修改值
        hashMap.put("张三", 98);  // 键已存在，值会被覆盖
        System.out.println("修改后的HashMap: " + hashMap);
        
        // 删除键值对
        hashMap.remove("李四");
        System.out.println("删除'李四'后: " + hashMap);
        
        // 获取所有键和值
        System.out.println("所有键: " + hashMap.keySet());
        System.out.println("所有值: " + hashMap.values());
        
        // 遍历Map
        System.out.println("\n===遍历方式1：使用entrySet===");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("\n===遍历方式2：使用keySet===");
        for (String key : hashMap.keySet()) {
            System.out.println(key + ": " + hashMap.get(key));
        }
        
        // LinkedHashMap示例 - 保持插入顺序
        Map<String, Double> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("香蕉", 5.5);
        linkedHashMap.put("苹果", 8.0);
        linkedHashMap.put("橙子", 6.5);
        System.out.println("\nLinkedHashMap(保持插入顺序): " + linkedHashMap);
        
        // TreeMap示例 - 按键排序
        TreeMap<String, Double> treeMap = new TreeMap<>();
        treeMap.put("香蕉", 5.5);
        treeMap.put("苹果", 8.0);
        treeMap.put("橙子", 6.5);
        System.out.println("\nTreeMap(按键排序): " + treeMap);
        
        // TreeMap的特殊方法
        System.out.println("第一个键：" + treeMap.firstKey());
        System.out.println("最后一个键：" + treeMap.lastKey());
        System.out.println("小于'香蕉'的条目：" + treeMap.headMap("香蕉"));
        System.out.println("大于等于'香蕉'的条目：" + treeMap.tailMap("香蕉"));
        System.out.println("'苹果'和'香蕉'之间的条目：" + treeMap.subMap("苹果", "香蕉"));
        
        // 默认值
        System.out.println("\n不存在的键：" + hashMap.get("赵六"));  // 返回null
        System.out.println("使用getOrDefault: " + hashMap.getOrDefault("赵六", 0));  // 返回默认值0
        
        // 仅当键不存在时才添加
        hashMap.putIfAbsent("张三", 100);  // 键已存在，不会修改
        hashMap.putIfAbsent("赵六", 85);   // 键不存在，会添加
        System.out.println("\n使用putIfAbsent后: " + hashMap);
    }
} 