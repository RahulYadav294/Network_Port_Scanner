import javax.swing.*;
import java.awt.*;
import java.net.Socket;
import javax.swing.JOptionPane;

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

            String host = hostField.getText().trim();

            if(host.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Host/IP cannot be empty!"
                );

                return;
            }

            int startPort;
            int endPort;

            try {

                startPort =
                        Integer.parseInt(
                                startPortField.getText().trim());

                endPort =
                        Integer.parseInt(
                                endPortField.getText().trim());

            } catch(NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Ports must be numbers!"
                );

                return;
            }

            if(startPort < 1 || startPort > 65535) {

                JOptionPane.showMessageDialog(
                        this,
                        "Start Port must be between 1 and 65535!"
                );

                return;
            }

            if(endPort < 1 || endPort > 65535) {

                JOptionPane.showMessageDialog(
                        this,
                        "End Port must be between 1 and 65535!"
                );

                return;
            }

            if(startPort > endPort) {

                JOptionPane.showMessageDialog(
                        this,
                        "Start Port cannot be greater than End Port!"
                );

                return;
            }

            resultArea.setText("");
            long startTime = System.currentTimeMillis();

            new Thread(() -> {
                final int[] openPortCount = {0};
                for(int port = startPort;
                    port <= endPort;
                    port++) {

                    try {

                        Socket socket =
                                new Socket(host, port);
                        openPortCount[0]++;

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
                long endTime = System.currentTimeMillis();

                double seconds =
                        (endTime - startTime) / 1000.0;

                int totalPorts =
                        endPort - startPort + 1;
                resultArea.append("\n");
                resultArea.append("====================\n");
                resultArea.append("SCAN SUMMARY\n");
                resultArea.append("====================\n");

                resultArea.append(
                        "Target: "
                                + host
                                + "\n"
                );

                resultArea.append(
                        "Total Ports Scanned: "
                                + totalPorts
                                + "\n"
                );

                resultArea.append(
                        "Open Ports Found: "
                                + openPortCount[0]
                                + "\n"
                );

                resultArea.append(
                        "Time Taken: "
                                + seconds
                                + " seconds\n"
                );

            }).start();

        });
    }
}