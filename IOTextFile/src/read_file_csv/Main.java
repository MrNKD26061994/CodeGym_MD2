package read_file_csv;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Country> listContry = readAndWriteFile.readFile("src/read_file_csv/file.csv");
        for (Country item : listContry) {
            System.out.println(item.getName());
        }
    }

}
