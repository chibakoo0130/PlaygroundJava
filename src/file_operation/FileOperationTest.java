package file_operation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;

import org.junit.Test;

public class FileOperationTest {

    public static final String FILE_SEPARATOR = File.separator;
    public static final String CURRENT_DIR = System.getProperty("user.dir");

    @Test
    public void Fileコンストラクタでディレクトリを指定してファイルリストを取得する() {
	File dir = new File(CURRENT_DIR + FILE_SEPARATOR + "src" + FILE_SEPARATOR + "file_operation" + FILE_SEPARATOR);
	assertThat(dir.list(), is(new String[] {"FileOperationTest.java", "sample" }));
    }

}
