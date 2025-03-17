/**
 * 循环语句示例
 * 演示各种循环语句的使用方法
 */
public class LoopDemo {
    public static void main(String[] args) {
        // 1. for循环
        System.out.println("for循环示例：");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 2. while循环
        System.out.println("while循环示例：");
        int j = 1;
        while (j <= 5) {
            System.out.print(j + " ");
            j++;
        }
        System.out.println();

        // 3. do-while循环
        System.out.println("do-while循环示例：");
        int k = 1;
        do {
            System.out.print(k + " ");
            k++;
        } while (k <= 5);
        System.out.println();

        // 4. 嵌套循环
        System.out.println("嵌套循环示例 - 打印乘法表：");
        for (int i = 1; i <= 9; i++) {
            for (int m = 1; m <= i; m++) {
                System.out.print(m + "×" + i + "=" + (m * i) + "\t");
            }
            System.out.println();
        }

        // 5. 增强for循环（foreach）
        System.out.println("foreach循环示例：");
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 6. break和continue的使用
        System.out.println("break示例：");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) break;  // 当i等于6时，跳出循环
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("continue示例：");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;  // 当i是偶数时，跳过本次循环
            System.out.print(i + " ");
        }
        System.out.println();

        // 7. 带标签的break和带标签的continue示例
        System.out.println("带标签的continue示例：");
        outer:
        for (int i = 1; i <= 3; i++) {
            for (int m = 1; m <= 3; m++) {
                if (i == 2 && m == 2) {
                    continue outer;  // 跳过外层循环的当前迭代
                }
                System.out.print("(" + i + "," + m + ") ");
            }
            System.out.println(); // 当 i=2 时，此行不会执行
        }
        System.out.println("\n循环已结束");

        System.out.println("带标签的break示例：");
        outer:
        for (int i = 1; i <= 3; i++) {
            for (int m = 1; m <= 3; m++) {
                if (i == 2 && m == 2) {
                    break outer;  // 跳出外层循环
                }
                System.out.print("(" + i + "," + m + ") ");
            }
            System.out.println();
        }
        System.out.println("\n循环已结束");
    }
} 