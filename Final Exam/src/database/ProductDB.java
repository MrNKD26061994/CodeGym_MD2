package database;

import model.Product;

import java.io.BufferedWriter;
import java.io.IOException;

public class ProductDB extends AbstractDB<Product> {
    @Override
    public Product splitString(String str) {
        String[] arrStr = str.split(",");
        Product product = new Product();
        product.setId(Integer.parseInt(arrStr[0]));
        product.setCode(arrStr[1]);
        product.setName(arrStr[2]);
        product.setPrice(Integer.parseInt(arrStr[3]));
        product.setQuantity(Integer.parseInt(arrStr[4]));
        product.setDescription(arrStr[5]);
        return product;
    }

    @Override
    public void bufferedWriter(BufferedWriter bufferedWriter, Product product) throws IOException {
        bufferedWriter.write(product.getId() + ",");
        bufferedWriter.write(product.getCode() + ",");
        bufferedWriter.write(product.getName() + ",");
        bufferedWriter.write(product.getPrice() + ",");
        bufferedWriter.write(product.getQuantity() + ",");
        bufferedWriter.write(product.getDescription());
        bufferedWriter.newLine();
    }
}
