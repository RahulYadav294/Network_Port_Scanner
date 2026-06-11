import javax.swing.*;
import java.awt.*;
import java.net.Socket;

public class PortScannerGUI extends JFrame {

    JTextField hostField;
    JTextField startPortField;
    JTextField endPortField;
    JTextArea resultArea;
    JButton scanButton;

    public PortScannerGUI() {

        setTitle("Advanced Network Port Scanner");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Host/IP:"));
        hostField = new JTextField();
        inputPanel.add(hostField);

        inputPanel.add(new JLabel("Start Port:"));
        startPortField = new JTextField();
        inputPanel.add(startPortField);

        inputPanel.add(new JLabel("End Port:"));
        endPortField = new JTextField();
        inputPanel.add(endPortField);

        scanButton = new JButton("Scan");
        inputPanel.add(scanButton);

        add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        setVisible(true);
        scanButton.addActionListener(e -> {

            String host = hostField.getText();

            int startPort =
                    Integer.parseInt(startPortField.getText());

            int endPort =
                    Integer.parseInt(endPortField.getText());

            resultArea.setText("");

            new Thread(() -> {

                for(int port = startPort;
                    port <= endPort;
                    port++) {

                    try {

                        Socket socket =
                                new Socket(host, port);

                        String service =
                                ServiceDetector.getService(port);

                        String result =
                                "[OPEN] Port "
                                        + port
                                        + " -> "
                                        + service
                                        + "\n";

                        resultArea.append(result);

                        socket.close();

                    } catch(Exception ex) {

                    }
                }

            }).start();

        });
    }
}