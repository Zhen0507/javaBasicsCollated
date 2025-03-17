import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections工具类示例
 * 演示Collections类的常用方法
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(9);
        System.out.println("原始列表: " + numbers);
        
        // 排序
        Collections.sort(numbers);
        System.out.println("排序后: " + numbers);
        
        // 二分查找（要求列表已排序）
        int index = Collections.binarySearch(numbers, 8);
        System.out.println("8的位置: " + index);
        
        // 最大值和最小值
        System.out.println("最大值: " + Collections.max(numbers));
        System.out.println("最小值: " + Collections.min(numbers));
        
        // 反转
        Collections.reverse(numbers);
        System.out.println("反转后: " + numbers);
        
        // 打乱顺序
        Collections.shuffle(numbers);
        System.out.println("打乱后: " + numbers);
        
        // 交换元素
        Collections.swap(numbers, 0, 1);
        System.out.println("交换索引0和1后: " + numbers);
        
        // 替换所有元素
        Collections.replaceAll(numbers, 9, 99);
        System.out.println("替换9为99后: " + numbers);
        
        // 填充
        Collections.fill(numbers, 0);
        System.out.println("填充为0后: " + numbers);
        
        // 频率统计
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "apple");
        int frequency = Collections.frequency(words, "apple");
        System.out.println("\n'apple'出现的次数: " + frequency);
        
        // 不可修改的集合
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println("\n不可修改的列表: " + unmodifiableList);
        
        try {
            unmodifiableList.add("D");  // 尝试修改不可修改的列表
        } catch (Exception e) {
            System.out.println("修改不可修改列表时发生异常: " + e.getClass().getName());
        }
        
        // 自定义排序
        List<Person> people = new ArrayList<>();
        people.add(new Person("张三", 20));
        people.add(new Person("李四", 25));
        people.add(new Person("王五", 18));
        
        // 按年龄排序
        Collections.sort(people, Comparator.comparingInt(Person::getAge));
        System.out.println("\n按年龄排序: " + people);
        
        // 按姓名排序
        Collections.sort(people, Comparator.comparing(Person::getName));
        System.out.println("按姓名排序: " + people);
        
        // 空集合
        List<Object> emptyList = Collections.emptyList();
        System.out.println("\n空列表: " + emptyList);
        
        // 单例集合
        List<String> singletonList = Collections.singletonList("Only One");
        System.out.println("单例列表: " + singletonList);
    }
    
    static class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
        
        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
} 