package top.irvingsoft.code.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author TimeChaser
 * @date 2021/10/11 21:09
 */
public class TCPServer extends Thread {

    public static final String EXIT = "exit";
    private static ServerSocket serverSocket;

    public TCPServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000000);
    }

    public static boolean validatePort(String s) {
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        if (validatePort(args[0])) {
            new TCPServer(Integer.parseInt(args[0])).start();
        }
    }

    @Override
    public void run() {

        Socket socket = null;
        try {
            System.out.println("等待客户端的连接，端口号为：" + serverSocket.getLocalPort());
            socket = serverSocket.accept();
            System.out.println("远程客户端主机地址为：" + socket.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scan = new Scanner(System.in);

            Thread inputThread = null;
            Thread outputThread = null;
            inputThread = new Thread(() -> {
                try {
                    while (true) {
                        String inputString = in.readUTF();
                        if (inputString.length() != 0) {
                            System.out.println("Client: " + inputString);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            outputThread = new Thread(() -> {
                try {
                    while (true) {
                        String outputString = scan.nextLine();
                        if (outputString.equals(EXIT)) {
                            in.close();
                            out.close();
                            break;
                        }
                        if (outputString.length() != 0) {
                            out.writeUTF(outputString);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            inputThread.start();
            outputThread.start();

            outputThread.join();
            inputThread.interrupt();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
