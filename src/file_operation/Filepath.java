package file_operation;

import java.io.File;

public class Filepath {

    public static final String CURRENT_DIR = System.getProperty("user.dir");
    public static final String FILE_SEPARATOR = File.separator;

    // addContents()で用いるパス
    public static final String filepath1 = CURRENT_DIR + FILE_SEPARATOR + "src" + FILE_SEPARATOR +
		"file_operation" + FILE_SEPARATOR + "sample" + FILE_SEPARATOR + "addSample1.txt";

    public static final String filepath2 = CURRENT_DIR + FILE_SEPARATOR + "src" + FILE_SEPARATOR +
		"file_operation" + FILE_SEPARATOR + "sample" + FILE_SEPARATOR + "addSample2.txt";

    public static final String filepath3 = CURRENT_DIR + FILE_SEPARATOR + "src" + FILE_SEPARATOR +
		"file_operation" + FILE_SEPARATOR + "sample" + FILE_SEPARATOR + "addSample3.txt";

    public static final String filepath4 = CURRENT_DIR + FILE_SEPARATOR + "src" + FILE_SEPARATOR +
		"file_operation" + FILE_SEPARATOR + "sample" + FILE_SEPARATOR + "addSample.txt";
}
