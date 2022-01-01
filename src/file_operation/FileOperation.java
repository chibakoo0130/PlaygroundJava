package file_operation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperation {

    public static void outputFile(String output, String path) {
	Path filepath = Paths.get(path);
	try(BufferedWriter bw = Files.newBufferedWriter(filepath, StandardCharsets.UTF_8)) {
	    bw.write(output);
	    bw.newLine();
	} catch (IOException e) {
	    System.out.println(e);
	}
    }
}
