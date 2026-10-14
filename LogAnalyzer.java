
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class LogAnalyzer {
    public static void main(String[] args) {
        String[] files = {"log1.txt", "log2.txt", "log3.txt"};
        String keyword = "error";

        for (String file : files) {
            Path path = Paths.get(file);

            try {
                List<String> lines = Files.readAllLines(path);
                int total = lines.size();
                int count = 0;

                for (String line : lines) {
                    if (line.toLowerCase().contains(keyword)) {
                        count++;
                    }
                }

                long size = Files.size(path);

                System.out.println("File: " + file);
                System.out.println("Total lines: " + total);
                System.out.println("Lines containing error: " + count);
                System.out.println("File size: " + size + " bytes");
                System.out.println();

            } catch (IOException e) {
                System.out.println("Cannot read " + file + ": "
                                   + e.getMessage());
            }
        }
    }
}
