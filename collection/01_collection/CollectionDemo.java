import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection接口示例
 * 演示Collection接口的常用方法
 */
public class CollectionDemo {
    public static void main(String[] args) {
        // 创建Collection对象
        Collection<String> collection = new ArrayList<>();
        
        // 添加元素
        collection.add("Java");
        collection.add("Python");
        collection.add("C++");
        System.out.println("集合内容：" + collection);
        
        // 删除元素
        collection.remove("Python");
        System.out.println("删除后：" + collection);
        
        // 判断元素是否存在
        System.out.println("是否包含Java：" + collection.contains("Java"));
        System.out.println("是否包含Python：" + collection.contains("Python"));
        
        // 集合大小
        System.out.println("集合大小：" + collection.size());
        
        // 清空集合
        collection.clear();
        System.out.println("清空后是否为空：" + collection.isEmpty());
        
        // 批量操作
        Collection<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        
        Collection<String> list2 = new ArrayList<>();
        list2.add("B");
        list2.add("C");
        list2.add("D");
        
        // 并集 - 将list2中的元素添加到list1中
        Collection<String> union = new ArrayList<>(list1);
        union.addAll(list2);
        System.out.println("并集：" + union);
        
        // 交集 - list1和list2中都有的元素
        Collection<String> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);
        System.out.println("交集：" + intersection);
        
        // 差集 - list1中有但list2中没有的元素
        Collection<String> difference = new ArrayList<>(list1);
        difference.removeAll(list2);
        System.out.println("差集：" + difference);
        
        // 数组转换为集合
        String[] array = {"X", "Y", "Z"};
        Collection<String> fromArray = Arrays.asList(array);
        System.out.println("数组转集合：" + fromArray);
        
        // 集合转换为数组
        String[] toArray = collection.toArray(new String[0]);
        System.out.println("集合转数组：" + Arrays.toString(toArray));
    }
} 