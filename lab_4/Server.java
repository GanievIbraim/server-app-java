import java.io.*;
import java.net.*;
import java.util.Timer;
import java.util.TimerTask;

public class Server {
    private static final String GROUP = "233.0.0.1";
    private static final int PORT = 1502;
    private static final int INTERVAL = 10000;
    private static String message = "";

    public static void main(String[] args) {
        readMessageFromFile("message.txt");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                sendMulticastMessage();
            }
        }, 0, INTERVAL);
    }

    private static void readMessageFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            message = content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMulticastMessage() {
        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(GROUP);
            socket.send(new DatagramPacket(message.getBytes(), message.length(), group, PORT));
            System.out.println("Sent message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}