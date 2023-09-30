package service;

import database.ProductDB;
import model.Product;

import java.util.List;

public class ProductService {
    private static ProductService productCartServiceInstance;
    private final ProductDB productDB;
    private final List<Product> products;

    public ProductService() {
        productDB = new ProductDB();
        products = productDB.findAll("Products.txt");
    }

    public static ProductService productServiceInstance() {
        if(productCartServiceInstance == null) {
            productCartServiceInstance = new ProductService();
        }
        return productCartServiceInstance;
    }

    public boolean existsByCode(String code) {
        for(Product item : products) {
            if(item.getCode().equals(code)) return true;
        }
        return false;
    }

    public void create(Product product) {
        product.setId(createNewId());
        productDB.writeFile("Products.txt", product);
        products.add(product);
    }

    private int createNewId() {
        if(products.isEmpty()){
            return 1;
        } else {
            return products.stream().max((o1, o2) -> o1.getId() - o2.getId()).get().getId() + 1;
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByCode(String code) {
        for (Product item : products){
            if(item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
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

    public void delete(Product product) {
        products.remove(product);
        productDB.writeFile("Products.txt", products);
    }

    public Product getProductMax() {
        return products.stream().max((o1, o2) -> o1.getPrice() - o2.getPrice()).get();
    }
}
