import java.net.Socket;

public class PortScanner {

    public void scan(String host, int startPort, int endPort) {

        System.out.println("\nScanning " + host + "...\n");

        for (int port = startPort; port <= endPort; port++) {

            try {
                Socket socket = new Socket(host, port);

                String service = ServiceDetector.getService(port);

                System.out.println(
                        "[OPEN] Port "
                                + port
                                + " -> "
                                + service
                );
                socket.close();

            } catch (Exception e) {
                // Port is closed
            }
        }

        System.out.println("\nScan Completed.");
    }
}