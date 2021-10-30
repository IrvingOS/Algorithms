package top.irvingsoft.code.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author TimeChaser
 * @since 2021/10/11 22:45
 */
public class UDPClient {

    public static boolean validatePort(String s) {
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        if (validatePort(args[1])) {
            int port = Integer.parseInt(args[1]);
            InetAddress address = null;
            try {
                address = InetAddress.getByName(args[0]);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

            try (DatagramSocket socket = new DatagramSocket()) {
                //利用DatagramSocket创建连接对象，并绑定端口
                //抛出异常：SocketException

                //利用byte[]创建数据，
                //利用 DatagramPacket(byte[] buf, int length, InetAddress address, int port) 封装成包，
                //InetAddress.getByName("localhost")抛出异常：UnknownHostException
                //以便进行数据的传输。
                String data = "你好，服务器。";
                byte[] buf = data.getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);

                //发送数据，抛出异常：IOException
                System.out.println("向服务器发送信息：" + data);
                socket.send(packet);

                //接收来自于服务器端的数据
                buf = new byte[1024];
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.receive(packet);
                data = new String(packet.getData(), 0, packet.getLength());
                System.out.println("接收到的数据是：" + data);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
