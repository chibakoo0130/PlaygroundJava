package file_operation;

import static file_operation.Filepath.ADD_PATH1;
import static file_operation.Filepath.ADD_PATH2;
import static file_operation.Filepath.ADD_PATH3;
import static file_operation.Filepath.ADD_PATH4;

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

    public static void addContents() {
	// 1:writer.write

	Path path1 = Paths.get(ADD_PATH1);
	try(BufferedWriter bw = Files.newBufferedWriter(path1, StandardCharsets.UTF_8)) {
	    bw.write("1");
	    bw.write("2");
	    bw.write("3");
	} catch (IOException e) {
	    System.out.println(e);
	}

	// 2:writer.append
	Path path2 = Paths.get(ADD_PATH2);
	try(BufferedWriter bw = Files.newBufferedWriter(path2, StandardCharsets.UTF_8)) {
	    bw.append("1");
	    bw.append("2");
	    bw.append("3");
	} catch (IOException e) {
	    System.out.println(e);
	}

	// 3:一度closeして再度ファイルを開きwriteする
	Path path3 = Paths.get(ADD_PATH3);
	try (BufferedWriter bw = Files.newBufferedWriter(path3, StandardCharsets.UTF_8)) {
	    bw.write("1");
	    bw.write("2");
	} catch (IOException e) {
	    System.out.println(e);
	}

	try (BufferedWriter bw = Files.newBufferedWriter(path3, StandardCharsets.UTF_8)) {
	    bw.write("3");
	} catch (IOException e) {
	    System.out.println(e);
	}

	// 4:一度closeして再度ファイルを開きappendする
	Path path4 = Paths.get(ADD_PATH4);
	try (BufferedWriter bw = Files.newBufferedWriter(path4, StandardCharsets.UTF_8)) {
	    bw.write("1");
	    bw.write("2");
	} catch (IOException e) {
	    System.out.println(e);
	}
	try (BufferedWriter bw = Files.newBufferedWriter(path4, StandardCharsets.UTF_8)) {
	    bw.append("3");
	} catch (IOException e) {
	    System.out.println(e);
	}
    }
}
