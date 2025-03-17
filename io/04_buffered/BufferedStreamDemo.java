/**
 * 缓冲流示例
 * 演示BufferedInputStream, BufferedOutputStream, BufferedReader, BufferedWriter的使用
 */
public class BufferedStreamDemo {
    public static void main(String[] args) {
        // 缓冲字节输出流
        try (BufferedOutputStream bos = 
             new BufferedOutputStream(new FileOutputStream("buffered_byte.txt"))) {
            // 写入数据
            for (int i = 0; i < 10; i++) {
                bos.write(("Line " + i + "\n").getBytes());
            }
            System.out.println("数据已写入文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 缓冲字节输入流
        try (BufferedInputStream bis = 
             new BufferedInputStream(new FileInputStream("buffered_byte.txt"))) {
            // 读取数据
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, bytesRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 缓冲字符输出流
        try (BufferedWriter writer = 
             new BufferedWriter(new FileWriter("buffered_char.txt"))) {
            // 写入数据
            for (int i = 0; i < 10; i++) {
                writer.write("Line " + i);
                writer.newLine();  // 写入换行符
            }
            System.out.println("\n数据已写入文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 缓冲字符输入流
        try (BufferedReader reader = 
             new BufferedReader(new FileReader("buffered_char.txt"))) {
            // 按行读取
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 