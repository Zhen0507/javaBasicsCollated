/**
 * TCP客户端示例
 * 演示基于Socket的TCP通信
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            // 连接服务器
            Socket socket = new Socket("localhost", 8888);
            System.out.println("已连接到服务器");
            
            // 获取输入输出流
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);
            
            // 发送消息给服务器
            out.println("你好，服务器！");
            
            // 读取服务器响应
            String response = in.readLine();
            System.out.println("服务器响应: " + response);
            
            // 关闭连接
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 