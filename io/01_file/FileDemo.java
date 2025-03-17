/**
 * File类示例
 * 演示File类的基本操作
 */
public class FileDemo {
    public static void main(String[] args) {
        // 创建File对象
        File file1 = new File("test.txt");
        File file2 = new File("D:/temp/test.txt");
        File dir = new File("D:/temp");
        
        // 文件信息
        System.out.println("文件名：" + file1.getName());
        System.out.println("路径：" + file1.getPath());
        System.out.println("绝对路径：" + file1.getAbsolutePath());
        System.out.println("父目录：" + file1.getParent());
        
        // 文件状态
        System.out.println("是否存在：" + file1.exists());
        System.out.println("是否是文件：" + file1.isFile());
        System.out.println("是否是目录：" + file1.isDirectory());
        System.out.println("是否可读：" + file1.canRead());
        System.out.println("是否可写：" + file1.canWrite());
        
        // 创建目录
        if (!dir.exists()) {
            boolean created = dir.mkdir();  // 创建单级目录
            System.out.println("目录创建" + (created ? "成功" : "失败"));
        }
        
        // 创建多级目录
        File dirs = new File("D:/temp/a/b/c");
        if (!dirs.exists()) {
            boolean created = dirs.mkdirs();
            System.out.println("多级目录创建" + (created ? "成功" : "失败"));
        }
        
        // 创建文件
        if (!file2.exists()) {
            try {
                boolean created = file2.createNewFile();
                System.out.println("文件创建" + (created ? "成功" : "失败"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        // 列出目录内容
        if (dir.exists() && dir.isDirectory()) {
            String[] fileList = dir.list();
            System.out.println("目录内容：");
            for (String fileName : fileList) {
                System.out.println(fileName);
            }
            
            // 获取详细信息
            File[] files = dir.listFiles();
            for (File f : files) {
                System.out.println(f.getName() + " - " + 
                                  (f.isDirectory() ? "目录" : "文件") + " - " + 
                                  f.length() + "字节");
            }
        }
        
        // 删除文件
        if (file2.exists()) {
            boolean deleted = file2.delete();
            System.out.println("文件删除" + (deleted ? "成功" : "失败"));
        }
    }
} 