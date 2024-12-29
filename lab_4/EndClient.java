import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class EndClient extends JFrame {
    private JTextArea textArea = new JTextArea();

    public EndClient() {
        super("End Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton button = new JButton("Get Messages");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getMessagesFromIntermediateClient();
            }
        });
        getContentPane().add(button, BorderLayout.SOUTH);
    }

    private void getMessagesFromIntermediateClient() {
        textArea.setText("");
        try (Socket socket = new Socket("localhost", 1503);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String line;
            while ((line = in.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EndClient client = new EndClient();
            client.setVisible(true);
        });
    }
}