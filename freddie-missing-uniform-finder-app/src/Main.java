import com.mailChimp.freedie.app.processor.MessageProcessor;
import com.mailChimp.freedie.app.service.Impl.FoldServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Define the path to the resources folder containing the files to process
        Path folderPath = Paths.get("./resources");
        MessageProcessor messageProcessor = new MessageProcessor(new FoldServiceImpl());

        try (Stream<Path> paths = Files.list(folderPath)){

            paths.filter(Files::isRegularFile)
                    .forEach( file -> {
                        try {
                            // Process each file and perform the decoding operations
                            messageProcessor.process(file.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        }catch (IOException e) {
            System.out.println("Fail to get files from the resources fold. Please check the File path");
            e.printStackTrace();
        }

    }
}