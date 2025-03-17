/**
 * 转换流示例
 * 演示InputStreamReader和OutputStreamWriter的使用
 */
public class ConvertStreamDemo {
    public static void main(String[] args) {
        // 指定字符集写入文件
        try (OutputStreamWriter writer = 
             new OutputStreamWriter(new FileOutputStream("utf8.txt"), "UTF-8")) {
            writer.write("你好，Java IO！");
            System.out.println("数据已写入文件(UTF-8)");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 使用不同字符集读取文件
        try (InputStreamReader reader = 
             new InputStreamReader(new FileInputStream("utf8.txt"), "UTF-8")) {
            char[] buffer = new char[1024];
            int length = reader.read(buffer);
            System.out.println("读取的内容(UTF-8): " + new String(buffer, 0, length));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 使用GBK编码写入
        try (OutputStreamWriter writer = 
             new OutputStreamWriter(new FileOutputStream("gbk.txt"), "GBK")) {
            writer.write("你好，Java IO！");
            System.out.println("数据已写入文件(GBK)");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 使用GBK编码读取
        try (InputStreamReader reader = 
             new InputStreamReader(new FileInputStream("gbk.txt"), "GBK")) {
            char[] buffer = new char[1024];
            int length = reader.read(buffer);
            System.out.println("读取的内容(GBK): " + new String(buffer, 0, length));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 