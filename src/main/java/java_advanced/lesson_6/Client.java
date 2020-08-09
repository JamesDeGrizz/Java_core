package java_advanced.lesson_6;

import java.io.*;
import java.net.*;

public class Client {
    private static Socket socket;
    private static DataOutputStream out = null;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println("Client started");
                socket = new Socket(Info.address, Info.port);
                System.out.println("Client connected");
                DataInputStream in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    String message = in.readUTF();
                    System.out.println((Info.received + message));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    String message = reader.readLine();

                    if (out != null) {
                        out.writeUTF(message);
                    } else {
                        System.out.println("No active connections");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
