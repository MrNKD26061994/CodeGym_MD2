package service;

import database.ProductDB;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static ProductService productService;
    private final ProductDB productDB;
    private final List<Product> products;
    public ProductService() {
        productDB = new ProductDB();
        products = productDB.findAll("Products.txt");
    }
    public static ProductService productService() {
        if(productService == null) {
            productService = new ProductService();
        }
        return productService;
    }

    public void create(Product product) {
        product.setId(createNewId());
        productDB.writeFile("Products.txt", product);
        products.add(product);
    }

    public void update(Product product) {
        for (int i = 0; i < products.size() - 1; i++) {
            if(products.get(i).getId() == product.getId()) {
                products.set(i, product);
                break;
            }
        }
        productDB.writeFile("Products.txt", products);
    }

    private int createNewId() {
        if(products.isEmpty()){
            return 1;
        } else {
            return products.stream().max((o1, o2) -> o1.getId() - o2.getId()).get().getId() + 1;
        }
    }
    public Product getProductById(int id) {
        for (Product item : products){
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean existsById(int id) {
        for(Product item : products) {
            if(item.getId() == id) return true;
        }
        return false;
    }

    public List<Product> getProductByCategory(int idCategory) {
        List<Product> list = new ArrayList<>();
        for (Product item : products) {
            if(item.getCategory().getId() == idCategory) {
                list.add(item);
            }
        }
        return list;
    }

    public void subQuantityProductById(int id, int quantity) {
        for (Product item : products) {
            if(item.getId() == id) {
                item.setQuantity(item.getQuantity() - quantity);
                break;
            }
        }
        productDB.writeFile("Products.txt", products);
    }
}
