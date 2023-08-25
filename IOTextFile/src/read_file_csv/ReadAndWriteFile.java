package read_file_csv;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    
    public Country getCountry(String str) {
        String[] arrStr = str.split(",");
        Country country = new Country();
        country.setId(Integer.parseInt(arrStr[0]));
        country.setCode(arrStr[1].substring(1, arrStr[1].length() - 1));
        country.setName(arrStr[2].substring(1, arrStr[2].length() - 1));
        return country;
    }
}
