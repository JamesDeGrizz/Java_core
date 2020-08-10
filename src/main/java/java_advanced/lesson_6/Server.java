package java_advanced.lesson_6;

import java.io.*;
import java.net.*;

public class Server {
    private static Socket socket;
    private static DataOutputStream out = null;

    public static void main(String[] args) {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(Info.port)) {
                System.out.println("Server started, waiting for connection...");
                socket = serverSocket.accept();
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
