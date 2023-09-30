package database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDB<T> {
    public List<T> findAll(String filePath) {
        List<T> list = new ArrayList<>();
        try {
            File fileRead = new File("src/files/" + filePath);
            if(!fileRead.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRead));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                list.add(this.splitString(line));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại");
        }
        return list;
    }

    public void writeFile(String filePath, List<T> list){
        try {
            FileWriter writer = new FileWriter("src/files/" + filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (T item : list) {
                bufferedWriter(bufferedWriter, item);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String filePath, T t) {
        try {
            FileWriter writer = new FileWriter("src/files/" + filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter(bufferedWriter, t);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract T splitString(String str);

    public abstract void bufferedWriter(BufferedWriter bufferedWriter, T t) throws IOException;
}
