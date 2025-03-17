import java.util.Arrays;

/**
 * 数组示例
 * 演示数组的创建、初始化和基本操作
 */
public class ArrayDemo {
    public static void main(String[] args) {
        // 1. 数组的创建和初始化
        int[] arr1 = new int[5];           // 创建指定长度的数组
        int[] arr2 = {1, 2, 3, 4, 5};      // 创建并初始化数组
        
        // 2. 数组元素的访问
        arr1[0] = 10;                      // 为数组元素赋值
        System.out.println("第一个元素：" + arr1[0]);
        System.out.println("数组长度：" + arr1.length);
        
        // 3. 数组的遍历
        System.out.println("使用for循环遍历：");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        
        // 4. 二维数组
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("二维数组遍历：");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // 5. 数组工具类Arrays的使用
        int[] arr3 = {5, 2, 8, 1, 9};
        Arrays.sort(arr3);                  // 数组排序
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(arr3));
        
        // 6. 数组拷贝
        int[] copied = Arrays.copyOf(arr3,arr3.length);
        System.out.println("拷贝的数组：");
        System.out.println(Arrays.toString(copied));
    }
} 