/**
 * URL编程示例
 * 演示URL类的使用
 */
public class URLDemo {
    public static void main(String[] args) {
        try {
            // 创建URL对象
            URL url = new URL("https://www.baidu.com/index.html?id=123#top");
            
            // 获取URL的各个部分
            System.out.println("协议: " + url.getProtocol());
            System.out.println("主机名: " + url.getHost());
            System.out.println("端口号: " + url.getPort());
            System.out.println("文件路径: " + url.getPath());
            System.out.println("查询参数: " + url.getQuery());
            System.out.println("片段标识符: " + url.getRef());
            
            // 读取URL内容
            URL contentUrl = new URL("https://www.baidu.com");
            URLConnection connection = contentUrl.openConnection();
            
            // 设置请求属性
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            // 建立连接
            connection.connect();
            
            // 获取响应头信息
            System.out.println("\n响应头信息:");
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            
            // 读取内容
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                System.out.println("\n页面内容(前100个字符):");
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                    if (content.length() > 100) break;
                }
                System.out.println(content.substring(0, 100) + "...");
            }
            
            // 下载文件示例
            URL fileUrl = new URL("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
            try (InputStream in = fileUrl.openStream();
                 FileOutputStream out = new FileOutputStream("baidu_logo.png")) {
                
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                System.out.println("\n文件下载完成");
            }
            
        } catch (MalformedURLException e) {
            System.out.println("URL格式错误");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 