package database;

import model.Category;

import java.io.BufferedWriter;
import java.io.IOException;

public class CategoryDB extends AbstractDB<Category> {
    @Override
    public Category splitString(String str) {
        String[] arrStr = str.split(",");
        Category category = new Category();
        category.setId(Integer.parseInt(arrStr[0]));
        category.setName(arrStr[1]);
        category.setChgWho(arrStr[2]);
        category.setChgDate(arrStr[3]);
        category.setStatus(Integer.parseInt(arrStr[4]));
        return category;
    }

    @Override
    public void bufferedWriter(BufferedWriter bufferedWriter, Category category) throws IOException {
        bufferedWriter.write(category.getId() + ",");
        bufferedWriter.write(category.getName() + ",");
        bufferedWriter.write(category.getChgWho() + ",");
        bufferedWriter.write(category.getChgDate() + ",");
        bufferedWriter.write(category.getStatus() + "");
        bufferedWriter.newLine();
    }
}
