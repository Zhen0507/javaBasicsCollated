/**
 * 字符流示例
 * 演示FileReader和FileWriter的使用
 */
public class CharStreamDemo {
    public static void main(String[] args) {
        // 文件写入器 - 写入文件
        try (FileWriter writer = new FileWriter("char.txt")) {
            // 写入单个字符
            writer.write('A');
            
            // 写入字符数组
            char[] chars = {'B', 'C', 'D', 'E'};
            writer.write(chars);
            
            // 写入字符数组的一部分
            writer.write(chars, 1, 2);  // 写入'C', 'D'
            
            // 写入字符串
            writer.write("Hello, Java IO!");
            
            System.out.println("数据已写入文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 文件读取器 - 读取文件
        try (FileReader reader = new FileReader("char.txt")) {
            // 读取单个字符
            int c = reader.read();
            System.out.println("读取的第一个字符: " + (char)c);
            
            // 读取到字符数组
            char[] buffer = new char[1024];
            int length = reader.read(buffer);
            
            System.out.println("读取的内容: ");
            for (int i = 0; i < length; i++) {
                System.out.print(buffer[i]);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 