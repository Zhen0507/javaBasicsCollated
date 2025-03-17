/**
 * UDP服务器示例
 * 演示基于DatagramSocket的UDP通信
 */
public class UDPServer {
    public static void main(String[] args) {
        try {
            // 创建DatagramSocket，监听9999端口
            DatagramSocket socket = new DatagramSocket(9999);
            System.out.println("UDP服务器启动，等待数据...");
            
            // 创建接收数据的包
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            // 接收数据
            socket.receive(packet);
            
            // 处理接收到的数据
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("收到数据: " + message);
            System.out.println("来自: " + packet.getAddress() + ":" + packet.getPort());
            
            // 发送响应
            String response = "服务器已收到: " + message;
            byte[] responseData = response.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(
                responseData, 
                responseData.length, 
                packet.getAddress(), 
                packet.getPort()
            );
            socket.send(responsePacket);
            
            // 关闭socket
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 