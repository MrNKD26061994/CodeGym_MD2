package copy_file_text;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<String> listStr = readAndWriteFile.readFile("src/copy_file_text/source.txt");
        readAndWriteFile.writeFile("src/copy_file_text/target.txt", listStr);
    }
}
