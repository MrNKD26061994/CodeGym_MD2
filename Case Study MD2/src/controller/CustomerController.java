package controller;

import model.Cart;
import model.Category;
import model.Product;
import model.ProductCart;
import service.*;
import utils.MyScanner;
import views.*;

import java.util.List;
import java.util.Scanner;

public class CustomerController {

    private static CustomerController customerController;
    private final Scanner scanner;
    private final Menu menu;
    private final ViewAccount viewAccount;
    private final UserService userService;

    private final ViewCategory viewCategory;

    private final CategoryService categoryService;

    private final ViewProduct viewProduct;
    private final ProductService productService;
    private final CartService cartService;
    private final ProductCartService productCartService;
    private final ViewCart viewCart;
    public CustomerController() {
        menu = Menu.menuInstance();
        scanner = MyScanner.scannerInstance();

        viewAccount = ViewAccount.viewUserInstance();
        userService = UserService.userServiceInstance();

        viewCategory = ViewCategory.viewCategoryInstance();
        categoryService = CategoryService.categoryServiceInstance();

        viewProduct = ViewProduct.viewProduct();
        productService = ProductService.productService();

        cartService = CartService.cartServiceInstance();
        productCartService = ProductCartService.productCartServiceInstance();
        viewCart = ViewCart.viewCart();
    }

    public static CustomerController customerControllerInstance() {
        if (customerController == null) {
            customerController = new CustomerController();
        }
        return customerController;
    }

    public void viewCustomer(String username) {
        int choiceCustomer;
        do {
            menu.viewCustomer();
            choiceCustomer = Integer.parseInt(scanner.nextLine());
            switch (choiceCustomer) {
                case 1:
                    viewAccount.displayUser(userService.getUserByUserName(username));
                    break;
                case 2:
                    manageCategories(username);
                    break;
                case 3:
//                    manageProducts(username);
                    break;
                case 4:
                    manageCart(username);
                    break;
                case 5:
                    manageBills(username);
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (choiceCustomer != 0);
    }

    private void manageBills(String username) {
        cartService.displayBills(username);
    }

    private void manageCart(String username) {
        cartService.displayCart(username);
        int choiceCart;
        do {
            menu.viewCartNotPay();
            choiceCart = Integer.parseInt(scanner.nextLine());
            switch (choiceCart) {
                case 1:
                    break;
                case 2:
                    managePlusOrSubProductByCart(username, "plus");
                    break;
                case 3:
                    managePlusOrSubProductByCart(username,"sub");
                    break;
                case 4:
                case 5:
                    paymentCart(username);
                    choiceCart = 0;
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (choiceCart != 0);
    }

    private void paymentCart(String username) {
        Cart cart = cartService.getIdCartNoPayByUser(username);

        List<ProductCart> list = productCartService.getProductCartListById(cart.getId());
        for (ProductCart item : list) {
            if(item.getQuantity() <= productService.getProductById(item.getProduct().getId()).getQuantity()){
                productService.subQuantityProductById(item.getProduct().getId(), item.getQuantity());
                if(categoryPay().equals("tt")) {
                    cartService.paymentCart(username);
                } else {
                    System.out.println("Tính năng đang hoàn thiện");
                }
            } else {
                System.out.println("Số lượng sản phẩm không đủ");
            }
            break;
        }
    }

    private void managePlusOrSubProductByCart(String username, String operator) {
        cartService.displayCart(username);
        Cart cart = cartService.getIdCartNoPayByUser(username);
        int choiceIdProduct = 0;
        do {
            List<ProductCart> productCarts = productCartService.getProductCartListById(cart.getId());
            viewCart.displayProductCarts(productCarts);
            viewCart.displayLinePrivate();
            viewCart.getQuoteLine();
            try {
                choiceIdProduct = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                viewProduct.getErrorEnterStr();
            }
            if(choiceIdProduct < 0 || choiceIdProduct > productCarts.size()) {
                System.out.println("Error: Enter not product");
            } else if (choiceIdProduct != 0) {
                ProductCart productCart = new ProductCart();
                productCart.setCart(cart);
                productCart.setProduct(productCarts.get(choiceIdProduct - 1).getProduct());
                if(operator.equals("plus")){
                    productCartService.create(productCart);
                } else if(operator.equals("sub")) {
                    productCartService.sub(productCart);

                }
            }
        }while (choiceIdProduct != 0);
    }

    private void manageCategories(String username) {
        int choiceIdCategory = 0;
        do {
            List<Category> categories = categoryService.getCategories();
            viewCategory.displayCategories(categories);
            viewCategory.displayLinePrivate();
            viewCategory.getQuoteLine();
            try {
                choiceIdCategory = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                viewCategory.getErrorEnterStr();
            }

            if(choiceIdCategory < 0 || choiceIdCategory > categories.size()) {
                System.out.println("Error: Enter not category");
            } else if(choiceIdCategory != 0) {
                manageProductByCategory(username, choiceIdCategory);
            }
        } while (choiceIdCategory != 0);
    }

    private void manageProductByCategory(String username, int idCategory) {
        int choiceIdProduct = 0;
        do {
            List<Product> products = productService.getProductByCategory(idCategory);
            viewProduct.displayProducts(products);
            viewCategory.displayLinePrivate();
            viewCategory.getQuoteLine();
            try {
                choiceIdProduct = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                viewProduct.getErrorEnterStr();
            }
            if(choiceIdProduct < 0 || choiceIdProduct > products.size()) {
                System.out.println("Error: Enter not product");
            } else if (choiceIdProduct != 0) {
                cartService.addProduct(username, productService.getProductById(products.get(choiceIdProduct - 1).getId()));
            }
        }while (choiceIdProduct != 0);
    }

    public String categoryPay() {
        System.out.println("Chọn hình thức thanh toán");
        System.out.println("1. Thanh toán trực tuyến");
        System.out.println("2. Thanh toán Banking");
        int payChoise = Integer.parseInt(scanner.nextLine());
        switch (payChoise) {
            case 1:
                return "tt";
            case 2:
                return "bk";
        }
        return "tt";
    }
}
