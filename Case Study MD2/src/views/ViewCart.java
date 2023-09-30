package views;

import model.Cart;
import model.ProductCart;
import service.CartService;

import java.util.List;

public class ViewCart extends ViewAbstract{
    private static ViewCart viewCart;



    public static ViewCart viewCart() {
        if (viewCart == null) {
            viewCart = new ViewCart();
        }
        return viewCart;
    }

    public void displayProdcutCartList(List<ProductCart> list) {
        System.out.printf("%-5s%-20s%-20s%-10s%s\n", "STT", "ProductName","Price", "Quantity", "Money");
        CartService cartService = CartService.cartServiceInstance();
        for (ProductCart item : list) {
            System.out.printf("%-5d%-20s%-20d%-10d%d\n", list.indexOf(item) + 1, item.getProduct().getName(), item.getProduct().getPrice(), item.getQuantity(), item.getQuantity()*item.getProduct().getPrice());
        }
        System.out.printf("%-55s%d\n\n", "Total: ", cartService.getTotal(list));

    }

    public void displayUserOfCart(Cart cart) {
        System.out.println("Cart");
        System.out.printf("%-20s%-20s\n", "Username", "Email");
        System.out.printf("%-20s%-20s\n", cart.getUser().getUsername(), cart.getUser().getEmail());
    }

    public void errorCartNull() {
        System.out.println("Error: Cart isEmpty");
    }

    public void displayInfoBills(Cart item) {
        System.out.printf("%-20s%-20s\n", "Date pay:", item.getChgDate());
    }

    public void displayProductCarts(List<ProductCart> productCarts) {
        if(!productCarts.isEmpty()) {
            viewCart.displayUserOfCart(productCarts.get(0).getCart());
            viewCart.displayProdcutCartList(productCarts);
        }
    }
}
