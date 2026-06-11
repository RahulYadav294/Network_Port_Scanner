import java.net.Socket;

public class PortScanner {
    public void scan(String host, int startPort, int endPort) {

        System.out.println("\nScanning " + host + "...\n");

        for (int port = startPort; port <= endPort; port++) {

            final int currentPort = port;

            Thread thread = new Thread(() -> {

                try {

                    Socket socket = new Socket(host, currentPort);

                    String service =
                            ServiceDetector.getService(currentPort);

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