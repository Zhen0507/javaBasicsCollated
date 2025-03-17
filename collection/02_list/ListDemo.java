import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * List接口示例
 * 演示ArrayList和LinkedList的使用
 */
public class ListDemo {
    public static void main(String[] args) {
        // ArrayList示例
        List<String> arrayList = new ArrayList<>();
        
        // 添加元素
        arrayList.add("苹果");
        arrayList.add("香蕉");
        arrayList.add("橙子");
        System.out.println("ArrayList: " + arrayList);
        
        // 在指定位置添加元素
        arrayList.add(1, "葡萄");
        System.out.println("添加元素后: " + arrayList);
        
        // 按索引访问
        System.out.println("第二个水果：" + arrayList.get(1));
        
        // 修改元素
        arrayList.set(1, "草莓");
        System.out.println("修改后的列表：" + arrayList);
        
        // 删除元素
        arrayList.remove(2);  // 按索引删除
        System.out.println("删除索引2的元素后: " + arrayList);
        
        arrayList.remove("苹果");  // 按对象删除
        System.out.println("删除'苹果'后: " + arrayList);
        
        // 查找元素位置
        int pos = arrayList.indexOf("橙子");
        System.out.println("'橙子'的位置: " + pos);
        
        // 获取子列表
        List<String> subList = arrayList.subList(0, 1);
        System.out.println("子列表: " + subList);
        
        // LinkedList示例
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println("\nLinkedList: " + linkedList);
        
        // LinkedList特有方法
        linkedList.addFirst("First");
        linkedList.addLast("Last");
        System.out.println("添加首尾元素后: " + linkedList);
        
        // 获取首尾元素
        System.out.println("第一个元素: " + linkedList.getFirst());
        System.out.println("最后一个元素: " + linkedList.getLast());
        
        // 删除首尾元素
        System.out.println("删除首元素：" + linkedList.removeFirst());
        System.out.println("删除尾元素：" + linkedList.removeLast());
        System.out.println("删除首尾元素后: " + linkedList);
        
        // 作为队列使用
        linkedList.offer("D");  // 添加到队尾
        System.out.println("入队后: " + linkedList);
        
        String poll = linkedList.poll();  // 从队首移除
        System.out.println("出队元素: " + poll);
        System.out.println("出队后: " + linkedList);
        
        // 作为栈使用
        linkedList.push("E");  // 压栈
        System.out.println("压栈后: " + linkedList);
        
        String pop = linkedList.pop();  // 出栈
        System.out.println("出栈元素: " + pop);
        System.out.println("出栈后: " + linkedList);
        
        // List排序
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        System.out.println("\n排序前: " + numbers);
        
        Collections.sort(numbers);
        System.out.println("排序后: " + numbers);
        
        // 逆序
        Collections.reverse(numbers);
        System.out.println("逆序后: " + numbers);
    }
} 