package top.irvingsoft.code.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author TimeChaser
 * @since 2021/10/11 21:01
 */
public class TCPClient {

    public static String EXIT = "exit";

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
            try (Socket client = new Socket(args[0], Integer.parseInt(args[1]))) {
                System.out.println("连接到主机：" + args[0] + "，端口号：" + args[1]);
                System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                Scanner scan = new Scanner(System.in);

                Thread inputThread = null;
                Thread outputThread = null;
                inputThread = new Thread(() -> {
                    try {
                        while (true) {
                            String inputString = in.readUTF();
                            if (inputString.length() != 0) {
                                System.out.println("Server: " + inputString);
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
            }
        }
    }
}
