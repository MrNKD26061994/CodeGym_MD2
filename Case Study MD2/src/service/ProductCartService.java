package service;

import database.ProductCartDB;
import model.ProductCart;

import java.util.ArrayList;
import java.util.List;

public class ProductCartService {
    private static ProductCartService productCartServiceInstance;
    private final ProductCartDB productCartDB;
    private final List<ProductCart> productCarts;
    public ProductCartService() {
        productCartDB = new ProductCartDB();
        productCarts = productCartDB.findAll("ProductsCarts.txt");
    }

    public static ProductCartService productCartServiceInstance() {
        if(productCartServiceInstance == null) {
            productCartServiceInstance = new ProductCartService();
        }
        return productCartServiceInstance;
    }

    public List<ProductCart> getProductCartListById(int idCart) {
        List<ProductCart> list = new ArrayList<>();
        for (ProductCart item : productCarts) {
            if(item.getCart().getId() == idCart) {
                list.add(item);
            }
        }
        return list;
    }

    public void create(ProductCart productCart) {
        boolean flag = false;
        for (ProductCart item : productCarts) {
            if(item.getCart().getId() == productCart.getCart().getId()) {
                if(item.getProduct().getId() == productCart.getProduct().getId()) {
                    item.setQuantity(item.getQuantity() + 1);
                    productCartDB.writeFile("ProductsCarts.txt", productCarts);
                    flag = true;
                    break;
                }
            }
        }
        if(!flag) {
            productCart.setQuantity(1);
            productCarts.add(productCart);
            productCartDB.writeFile("ProductsCarts.txt", productCart);
        }
    }

    public void sub(ProductCart productCart) {
        for (ProductCart item : productCarts) {
            if(item.getCart().getId() == productCart.getCart().getId()) {
                if(item.getProduct().getId() == productCart.getProduct().getId()) {
                    item.setQuantity(item.getQuantity() - 1);
                    if(item.getQuantity() <= 0) {
                        productCarts.remove(item);
                        CartService cartService = CartService.cartServiceInstance();
                        cartService.deleteCart(item.getCart());
                    }
                    productCartDB.writeFile("ProductsCarts.txt", productCarts);
                    break;
                }
            }
        }
    }
}
