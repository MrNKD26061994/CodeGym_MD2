package database;

import model.Cart;
import model.ProductCart;
import service.CartService;
import service.ProductService;

import java.io.BufferedWriter;
import java.io.IOException;

public class ProductCartDB extends AbstractDB<ProductCart> {
    @Override
    public ProductCart splitString(String str) {
        String[] arrStr = str.split(",");
        ProductCart productCart = new ProductCart();
        CartService cartService = CartService.cartServiceInstance();
        productCart.setCart(cartService.getCartById(Integer.parseInt(arrStr[0])));
        ProductService productService = ProductService.productService();
        productCart.setProduct(productService.getProductById(Integer.parseInt(arrStr[1])));
        productCart.setQuantity(Integer.parseInt(arrStr[2]));
        return productCart;
    }

    @Override
    public void bufferedWriter(BufferedWriter bufferedWriter, ProductCart productCart) throws IOException {
        bufferedWriter.write(productCart.getCart().getId() + ",");
        bufferedWriter.write(productCart.getProduct().getId() + ",");
        bufferedWriter.write(productCart.getQuantity() + "");
        bufferedWriter.newLine();
    }
}
