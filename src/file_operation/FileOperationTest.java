package file_operation;

import static file_operation.FileOperation.outputFile;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FileOperationTest {

    public static final String FILE_SEPARATOR = File.separator;
    public static final String CURRENT_DIR = System.getProperty("user.dir");

    public static final String  DS_STORE = ".DS_Store";

    @Test
    public void Fileコンストラクタでディレクトリを指定してファイルとディレクトリのリストを取得する() {
	File dir = new File(CURRENT_DIR + FILE_SEPARATOR + "src" + FILE_SEPARATOR + "file_operation" + FILE_SEPARATOR);
	List<String> tmp = new ArrayList<String>(Arrays.asList(dir.list()));
	// MacOSで.DS_Storeファイルがある場合は除外する
	if (tmp.contains(DS_STORE)) {
	    tmp.remove(DS_STORE);
	}

	assertThat(tmp.toArray(new String[tmp.size()]), is(new String[] {"FileOperationTest.java", "FileOperation.java", "sample" }));
    }

    @Test
    public void 文字が書き込まれる() {
	String filepath = CURRENT_DIR + FILE_SEPARATOR + "src" + FILE_SEPARATOR +
		"file_operation" + FILE_SEPARATOR + "sample" + FILE_SEPARATOR + "sample.txt";
	outputFile("あいうえお", filepath);
	Path path = Paths.get(filepath);
	StringBuilder sb = new StringBuilder();
	try(BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

	    for (String line; (line = br.readLine()) != null; ) {
		sb.append(line);
	    }
	} catch (IOException e) {
	    System.out.println(e);
	}
	String actual = sb.toString();
	String expected = "あいうえお";
	assertThat(actual, is(expected));
    }

}
