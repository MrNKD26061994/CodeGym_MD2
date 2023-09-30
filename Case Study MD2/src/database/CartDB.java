package database;

import model.Cart;
import service.UserService;

import java.io.BufferedWriter;
import java.io.IOException;

public class CartDB extends AbstractDB<Cart>{

    @Override
    public Cart splitString(String str) {
        String[] arrStr = str.split(",");
        Cart cart = new Cart();
        cart.setId(Integer.parseInt(arrStr[0]));
        UserService userService = UserService.userServiceInstance();
        cart.setUser(userService.getUserById(Integer.parseInt(arrStr[1])));
        cart.setChgDate(arrStr[2]);
        cart.setStatus(Integer.parseInt(arrStr[3]));
        return cart;
    }

    @Override
    public void bufferedWriter(BufferedWriter bufferedWriter, Cart cart) throws IOException {
        bufferedWriter.write(cart.getId() + ",");
        bufferedWriter.write(cart.getUser().getId() + ",");
        bufferedWriter.write(cart.getChgDate() + ",");
        bufferedWriter.write(cart.getStatus() + "");
        bufferedWriter.newLine();
    }
}
