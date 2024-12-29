import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class IntermediateClient implements Runnable {
    private static final String GROUP = "233.0.0.1";
    private static final int PORT = 1502;
    private static final int TCP_PORT = 1503;
    private static String lastMessage = "";
    private static List<String> messageHistory = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(new IntermediateClient()).start();
        startTcpServer();
    }

    public void run() {
        try (MulticastSocket socket = new MulticastSocket(PORT)) {
            InetAddress group = InetAddress.getByName(GROUP);
            socket.joinGroup(group);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                socket.receive(packet);
                String receivedMessage = new String(packet.getData(), 0, packet.getLength());
                if (!receivedMessage.equals(lastMessage)) {
                    System.out.println("Received new message: " + receivedMessage);
                    lastMessage = receivedMessage;
                    messageHistory.add(lastMessage);
                    if (messageHistory.size() > 5) {
                        messageHistory.remove(0);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startTcpServer() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
                System.out.println("TCP Server started on port " + TCP_PORT);
                while (true) {
                    Socket socket = serverSocket.accept();
                    new Thread(() -> handleTcpConnection(socket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void handleTcpConnection(Socket socket) {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            for (String msg : messageHistory) {
                out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}