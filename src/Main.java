import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Host/IP: ");
        String host = sc.nextLine();

        System.out.print("Enter Start Port: ");
        int startPort = sc.nextInt();

        System.out.print("Enter End Port: ");
        int endPort = sc.nextInt();

        PortScanner scanner = new PortScanner();
        scanner.scan(host, startPort, endPort);

        sc.close();
    }
}