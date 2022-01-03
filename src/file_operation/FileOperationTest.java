package file_operation;

import static file_operation.FileOperation.*;
import static file_operation.Filepath.*;
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

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class FileOperationTest {

    private static final String  DS_STORE = ".DS_Store";

    public static class FileやPathの動作を見る {

	@Test
	    public void Fileコンストラクタでディレクトリを指定してファイルとディレクトリのリストを取得する() {
		File dir = new File(CURRENT_DIR + FILE_SEPARATOR + "src" + FILE_SEPARATOR + "file_operation" + FILE_SEPARATOR);
		List<String> tmp = new ArrayList<String>(Arrays.asList(dir.list()));
		// MacOSで.DS_Storeファイルがある場合は除外する
		if (tmp.contains(DS_STORE)) {
		    tmp.remove(DS_STORE);
		}
		assertThat(tmp.toArray(new String[tmp.size()]), is(new String[] {"FileOperationTest.java", "FileOperation.java", "sample", "Filepath.java" }));
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

    public static class writerのwriteとappendの違い {

	@Before
	public void setUp() {
	    addContents();
	}

	@Test
	public void writeするだけ() {
		String actual = readFile(filepath1);
		String expected = "123";
		assertThat(actual, is(expected));
	}

	@Test
	public void appendするだけ() {
		String actual = readFile(filepath2);
		String expected = "123";
		assertThat(actual, is(expected));
	}

	@Test
	public void 一度closeして再度ファイルを開きwriteする() {
		String actual = readFile(filepath3);
		String expected = "3";
		assertThat(actual, is(expected));
	}

	@Test
	public void 一度closeして再度ファイルを開きappendする() {
		String actual =readFile(filepath4);
		String expected = "3";
		assertThat(actual, is(expected));
	}

	private static String readFile(String filepath) {
		Path path1 = Paths.get(filepath);
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = Files.newBufferedReader(path1, StandardCharsets.UTF_8)) {
		    for (String line; (line = br.readLine()) != null; ) {
			sb.append(line);
		    }
		} catch (IOException e) {
		    System.out.println(e);
		}
		return sb.toString();
	}
    }
}
