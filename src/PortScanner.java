import java.net.Socket;

public class PortScanner {
    public void scan(String host, int startPort, int endPort) {
        try {
            new java.io.PrintWriter("scan-report.txt").close();
        } catch(Exception e) {
        }
        System.out.println("\nScanning " + host + "...\n");

        for (int port = startPort; port <= endPort; port++) {

            final int currentPort = port;

            Thread thread = new Thread(() -> {

                try {

                    Socket socket = new Socket(host, currentPort);

                    String service =
                            ServiceDetector.getService(currentPort);
                    String reportLine =
                            "Port "
                                    + currentPort
                                    + " -> "
                                    + service;

                    ReportGenerator.write(reportLine);

                    System.out.println(
                            "[OPEN] Port "
                                    + currentPort
                                    + " -> "
                                    + service
                    );

                    socket.close();

                } catch (Exception e) {
                    // closed
                }

            });

            thread.start();
        }

        System.out.println("\nScan Initiated...");
    }
}