import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流示例
 * 演示FileInputStream和FileOutputStream的使用
 */
public class ByteStreamDemo {
    public static void main(String[] args) {
        // 文件输出流 - 写入文件
        try (FileOutputStream fos = new FileOutputStream("byte.txt")) {
            // 写入单个字节
            fos.write(65);  // 写入字符'A'
            
            // 写入字节数组
            byte[] bytes = {66, 67, 68, 69};  // 'B', 'C', 'D', 'E'
            fos.write(bytes);
            
            // 写入字节数组的一部分
            fos.write(bytes, 1, 2);  // 写入'C', 'D'
            
            System.out.println("数据已写入文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 文件输入流 - 读取文件
        try (FileInputStream fis = new FileInputStream("byte.txt")) {
            // 读取单个字节
            int data = fis.read();
            System.out.println("读取的第一个字节: " + (char)data);
            
            // 读取到字节数组
            byte[] buffer = new byte[1024];
            int length = fis.read(buffer);
            
            System.out.println("读取的内容: ");
            for (int i = 0; i < length; i++) {
                System.out.print((char)buffer[i]);
            }
            System.out.println();
            
            // 读取所有内容 (兼容Java 8及以下版本)
            try (FileInputStream fis2 = new FileInputStream("byte.txt")) {
                byte[] allBytes = readAllBytes(fis2);
                System.out.println("所有内容: " + new String(allBytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // 兼容Java 8及以下版本的readAllBytes方法
    private static byte[] readAllBytes(FileInputStream fis) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int bytesRead;
        
        while ((bytesRead = fis.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        
        return output.toByteArray();
    }
} 