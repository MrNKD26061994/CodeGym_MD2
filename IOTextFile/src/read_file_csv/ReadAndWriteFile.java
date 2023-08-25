package read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Country> readFile(String filePath){
        List<Country> listContry = new ArrayList<>();
        try {
            File fileRead = new File(filePath);
            if(!fileRead.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRead));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                listContry.add(getCountry(line));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại");
        }
        return listContry;
    }

    public void writeFile(String filePath, List<Country> listCoutry){
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Country item : listCoutry) {
                bufferedWriter.write(item.getId() + ",");
                bufferedWriter.write("\"" + item.getCode() + "\"" + ",");
                bufferedWriter.write("\"" + item.getName() + "\"" + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Country getCountry(String str) {
        String[] arrStr = str.split(",");
        Country country = new Country();
        country.setId(Integer.parseInt(arrStr[0]));
        country.setCode(arrStr[1].substring(1, arrStr[1].length() - 1));
        country.setName(arrStr[2].substring(1, arrStr[2].length() - 1));
        return country;
    }
}
