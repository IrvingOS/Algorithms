package top.irvingsoft.code.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author TimeChaser
 * @since 2021/10/11 22:45
 */
public class UDPServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = null;
        int port = 8080;
        InetAddress address = InetAddress.getByName("localhost");

        try {
            socket = new DatagramSocket(port);

            while (true) {
                //定义数据包
                byte[] buf = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);

                //接收数据，抛出异常：IOException
                socket.receive(packet);

                //通过数据包得到传送数据的客户端的ip
                String ip = packet.getAddress().getHostAddress();
                System.out.println("数据来自于：" + ip);

                //解析数据
                String data = new String(packet.getData(), 0, packet.getLength());
                int clientPort = packet.getPort();
                System.out.println("端口号为：" + clientPort + "\n数据内容：" + data);

                //向客户端发送数据
                data = "你好，我是服务器。";
                buf = data.getBytes();
                packet = new DatagramPacket(buf, buf.length, address, clientPort);
                socket.send(packet);
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
