/**
 * UDP客户端示例
 * 演示基于DatagramSocket的UDP通信
 */
public class UDPClient {
    public static void main(String[] args) {
        try {
            // 创建DatagramSocket
            DatagramSocket socket = new DatagramSocket();
            
            // 准备发送的数据
            String message = "你好，UDP服务器！";
            byte[] data = message.getBytes();
            
            // 创建发送的数据包
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(
                data, 
                data.length, 
                serverAddress, 
                9999
            );
            
            // 发送数据包
            socket.send(packet);
            System.out.println("数据已发送");
            
            // 接收响应
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            
            // 处理响应
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("服务器响应: " + response);
            
            // 关闭socket
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 