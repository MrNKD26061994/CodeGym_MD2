package database;

import model.Product;
import service.CategoryService;

import java.io.BufferedWriter;
import java.io.IOException;

public class ProductDB extends AbstractDB<Product> {
    @Override
    public Product splitString(String str) {
        String[] arrStr = str.split(",");
        Product product = new Product();
        product.setId(Integer.parseInt(arrStr[0]));
        product.setName(arrStr[1]);
        CategoryService categoryService = CategoryService.categoryServiceInstance();
        product.setCategory(categoryService.getCategoryById(Integer.parseInt(arrStr[2])));
        product.setPrice(Integer.parseInt(arrStr[3]));
        product.setDescription(arrStr[4]);
        product.setQuantity(Integer.parseInt(arrStr[5]));
        product.setChgWho(arrStr[6]);
        product.setChgDate(arrStr[7]);
        product.setStatus(Integer.parseInt(arrStr[8]));
        return product;
    }

    @Override
    public void bufferedWriter(BufferedWriter bufferedWriter, Product product) throws IOException {
        bufferedWriter.write(product.getId() + ",");
        bufferedWriter.write(product.getName() + ",");
        bufferedWriter.write(product.getCategory().getId() + ",");
        bufferedWriter.write(product.getPrice() + ",");
        bufferedWriter.write(product.getDescription() + ",");
        bufferedWriter.write(product.getQuantity() + ",");
        bufferedWriter.write(product.getChgWho() + ",");
        bufferedWriter.write(product.getChgDate() + ",");
        bufferedWriter.write(product.getStatus() + "");
        bufferedWriter.newLine();
    }
}
