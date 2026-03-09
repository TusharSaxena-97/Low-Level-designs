package Logger.Entities;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileLogOutput extends LogDestination {

    private final String LOG_DIRECTORY;
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public FileLogOutput(String filePath)
    {
        this.LOG_DIRECTORY = filePath;
    }

    @Override
    public void Append(Message message) {

        try {
            // create logs directory if it doesn't exist
            Files.createDirectories(Paths.get(LOG_DIRECTORY));

            String fileName = LOG_DIRECTORY + LocalDate.now().format(formatter) + ".txt";

            FileWriter writer = new FileWriter(fileName, true); // append mode
            writer.write(message.toString());
            writer.write(System.lineSeparator());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}