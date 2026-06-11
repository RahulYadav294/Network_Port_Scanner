import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {

    public static synchronized void write(String data) {

        try(FileWriter writer =
                    new FileWriter("scan-report.txt", true)) {

            writer.write(data + "\n");

        } catch(IOException e) {

            System.out.println("Error writing report.");
        }
    }
}