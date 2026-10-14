
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FolderReport {
    public static void main(String[] args) {
        Path folder = Paths.get("lab-NN");
        Path report = Paths.get("folder-report.txt");

        try {
            try (var paths = Files.walk(folder);
                 var writer = Files.newBufferedWriter(report)) {

                for (Path path : (Iterable<Path>) paths::iterator) {
                    if (Files.isRegularFile(path)) {
                        BasicFileAttributes attr =
                            Files.readAttributes(
                                path, BasicFileAttributes.class
                            );

                        String info =
                            "Name: " + path.getFileName()
                            + ", Size: " + attr.size() + " bytes"
                            + ", Modified: "
                            + attr.lastModifiedTime();

                        writer.write(info);
                        writer.newLine();

                        System.out.println(info);
                    }
                }
            }

            System.out.println("Report saved to " + report);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
