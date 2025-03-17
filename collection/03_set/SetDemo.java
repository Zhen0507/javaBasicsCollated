import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set接口示例
 * 演示HashSet、LinkedHashSet和TreeSet的使用
 */
public class SetDemo {
    public static void main(String[] args) {
        // HashSet示例
        Set<String> hashSet = new HashSet<>();
        hashSet.add("苹果");
        hashSet.add("香蕉");
        hashSet.add("苹果");  // 重复元素不会被添加
        hashSet.add("橙子");
        System.out.println("HashSet：" + hashSet);  // 无序
        
        // 基本操作
        System.out.println("集合大小：" + hashSet.size());
        System.out.println("是否包含'香蕉'：" + hashSet.contains("香蕉"));
        hashSet.remove("香蕉");
        System.out.println("删除'香蕉'后：" + hashSet);
        
        // LinkedHashSet示例 - 保持插入顺序
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("苹果");
        linkedHashSet.add("香蕉");
        linkedHashSet.add("橙子");
        System.out.println("\nLinkedHashSet：" + linkedHashSet);  // 保持插入顺序
        
        // TreeSet示例 - 自然排序
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(1);
        treeSet.add(5);  // 重复元素不会被添加
        System.out.println("\nTreeSet：" + treeSet);  // 自动排序
        
        // TreeSet的区间操作
        System.out.println("第一个元素：" + treeSet.first());
        System.out.println("最后一个元素：" + treeSet.last());
        System.out.println("小于5的元素：" + treeSet.headSet(5));
        System.out.println("大于等于5的元素：" + treeSet.tailSet(5));
        System.out.println("2到8之间的元素：" + treeSet.subSet(2, 8));
        
        // 自定义对象的Set
        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("张三", 20));
        personSet.add(new Person("李四", 25));
        personSet.add(new Person("张三", 20));  // 需要重写equals和hashCode方法才能实现去重
        System.out.println("\n人员集合：" + personSet);
        
        // 使用TreeSet排序自定义对象
        TreeSet<Person> personTreeSet = new TreeSet<>();
        personTreeSet.add(new Person("张三", 20));
        personTreeSet.add(new Person("李四", 25));
        personTreeSet.add(new Person("王五", 18));
        System.out.println("\n排序后的人员集合：" + personTreeSet);
    }
    
    // 自定义类，实现Comparable接口以支持排序
    static class Person implements Comparable<Person> {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age && name.equals(person.name);
        }
        
        @Override
        public int hashCode() {
            return 31 * name.hashCode() + age;
        }
        
        @Override
        public int compareTo(Person other) {
            // 按年龄排序
            return this.age - other.age;
        }
    }
} 