/**
 * 网络编程基础示例
 * 演示InetAddress类的使用
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            // 获取本机地址
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("本机IP地址: " + localHost.getHostAddress());
            System.out.println("本机主机名: " + localHost.getHostName());
            
            // 根据主机名获取InetAddress实例
            InetAddress baidu = InetAddress.getByName("www.baidu.com");
            System.out.println("百度IP地址: " + baidu.getHostAddress());
            System.out.println("百度主机名: " + baidu.getHostName());
            
            // 获取所有地址
            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
            System.out.println("谷歌IP地址:");
            for (InetAddress addr : addresses) {
                System.out.println(addr.getHostAddress());
            }
            
            // 检查是否可达
            boolean reachable = baidu.isReachable(5000);  // 超时时间5秒
            System.out.println("百度是否可达: " + reachable);
            
        } catch (UnknownHostException e) {
            System.out.println("无法解析主机名");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 