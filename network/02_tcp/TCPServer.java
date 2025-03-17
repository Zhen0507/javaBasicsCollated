/**
 * TCP服务器示例
 * 演示基于Socket的TCP通信
 */
public class TCPServer {
    public static void main(String[] args) {
        try {
            // 创建服务器套接字，监听8888端口
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器启动，等待客户端连接...");
            
            // 接受客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接: " + socket.getInetAddress().getHostAddress());
            
            // 获取输入输出流
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);
            
            // 读取客户端发送的消息
            String message = in.readLine();
            System.out.println("收到客户端消息: " + message);
            
            // 发送响应给客户端
            out.println("服务器已收到: " + message);
            
            // 关闭连接
            socket.close();
            serverSocket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 