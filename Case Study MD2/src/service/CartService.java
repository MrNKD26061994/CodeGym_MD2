package service;

import database.CartDB;
import model.Cart;
import model.Product;
import model.ProductCart;
import utils.DateUtils;
import views.ViewCart;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    private static CartService cartService;
    private final CartDB cartDB;
    private final List<Cart> carts;
    private final ViewCart viewCart;
    public CartService() {
        viewCart = ViewCart.viewCart();
        cartDB = new CartDB();
        carts = cartDB.findAll("Carts.txt");
    }

    public static CartService cartServiceInstance() {
        if (cartService == null) {
            cartService = new CartService();
        }
        return cartService;
    }

    public Cart getCartById(int id) {
        for (Cart item : carts) {
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void addProduct(String username, Product product) {
        ProductCart productCart = new ProductCart();
        ProductCartService productCartService = ProductCartService.productCartServiceInstance();
        productCart.setProduct(product);
        boolean flag = false;
        for (Cart item : carts) {
            if(item.getUser().getUsername().equals(username)
            && item.getStatus() == 0) {
                productCart.setCart(item);
                flag = true;
                break;
            }
        }
        if(!flag) {
            Cart cart = creatNewCart(username);
            cart.setChgDate(DateUtils.converter(LocalDateTime.now(), "dd-MM-yyyy HH:mm:ss"));
            cartDB.writeFile("Carts.txt", cart);
            carts.add(cart);
            productCart.setCart(cart);
        }
        productCartService.create(productCart);
    }

    private Cart creatNewCart(String username) {
        Cart cart = new Cart();
        cart.setId(createNewId());
        UserService userService = UserService.userServiceInstance();
        cart.setUser(userService.getUserByUserName(username));
        cart.setStatus(0);
        return cart;
    }

    private int createNewId() {
        if(carts.isEmpty()) {
            return 1;
        } else {
            return carts.stream().max((o1, o2) -> o1.getId() - o2.getId()).get().getId() + 1;
        }
    }

    public void displayCart(String username) {
        Cart cart = getCartNotPayByUserName(username);
        ProductCartService productCartService = ProductCartService.productCartServiceInstance();
        assert cart != null;
        try {
            List<ProductCart> list = productCartService.getProductCartListById(cart.getId());
            viewCart.displayUserOfCart(cart);
            viewCart.displayProdcutCartList(list);
        } catch (NullPointerException e) {
            viewCart.errorCartNull();
        }
    }

    public Cart getCartNotPayByUserName(String username) {
        for (Cart item : carts) {
            if(item.getUser().getUsername().equals(username) && item.getStatus() == 0) {
                return item;
            }
        }
        return null;
    }

    public int getTotal(List<ProductCart> list) {
        int total = 0;
        for (ProductCart item : list) {
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        return total;
    }

    public void paymentCart(String username) {
        for (Cart item : carts) {
            if(item.getUser().getUsername().equals(username)
            && item.getStatus() == 0) {
                item.setStatus(1);
                item.setChgDate(DateUtils.converter(LocalDateTime.now(), "dd-MM-yyyy HH:mm:ss"));
                break;
            }
        }
        cartDB.writeFile("Carts.txt" ,carts);
    }

    public void displayBills(String username) {
        List<Cart> bills = getCartsByUser(username);
        ProductCartService productCartService = ProductCartService.productCartServiceInstance();
        if(bills.isEmpty()) {
            viewCart.errorCartNull();
        } else {
            viewCart.displayUserOfCart(bills.get(0));
            for (Cart item : bills) {
                assert item != null;
                try {
                    List<ProductCart> list = productCartService.getProductCartListById(item.getId());
                    viewCart.displayInfoBills(item);
                    viewCart.displayProdcutCartList(list);
                } catch (NullPointerException e) {
                    viewCart.errorCartNull();
                }
            }
        }
    }

    public List<Cart> getCartsByUser(String username) {
        List<Cart> list = new ArrayList<>();
        for (Cart item : carts) {
            if(item.getUser().getUsername().equals(username) && item.getStatus() == 1) {
                list.add(item);
            }
        }
        return list;
    }

    public Cart getIdCartNoPayByUser(String username) {
        for (Cart item : carts) {
            if(item.getUser().getUsername().equals(username)
            && item.getStatus() == 0){
                return item;
            }
        }
        return null;
    }

    public void deleteCart(Cart cart) {
        carts.remove(cart);
        cartDB.writeFile("Carts.txt", carts);
    }
}
