public class ServiceDetector {

    public static String getService(int port) {

        switch (port) {
            case 20:
            case 21:
                return "FTP";

            case 22:
                return "SSH";

            case 23:
                return "Telnet";

            case 25:
                return "SMTP";

            case 53:
                return "DNS";

            case 80:
                return "HTTP";

            case 110:
                return "POP3";

            case 143:
                return "IMAP";

            case 443:
                return "HTTPS";

            case 3306:
                return "MySQL";

            case 5432:
                return "PostgreSQL";

            default:
                return "Unknown Service";
        }
    }
}