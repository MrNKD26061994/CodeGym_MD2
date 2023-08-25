package copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<String> readFile(String filePath){
        List<String> listStr = new ArrayList<>();
        try {
            File fileRead = new File(filePath);
            if(!fileRead.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRead));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                listStr.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại");
        }
        return listStr;
    }

    public void writeFile(String filePath, List<String> listStr) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String item : listStr) {
                bufferedWriter.write(item + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
