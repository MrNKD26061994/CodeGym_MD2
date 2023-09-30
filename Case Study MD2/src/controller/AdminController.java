package controller;

import model.Category;
import model.Product;
import model.User;
import service.CategoryService;
import service.ProductService;
import service.UserService;
import utils.MyScanner;
import views.Menu;
import views.ViewAccount;
import views.ViewCategory;
import views.ViewProduct;

import java.util.Scanner;

public class AdminController {
    private static AdminController adminController;
    private final Scanner scanner;
    private final Menu menu;

    private final UserService userService;
    private final ViewAccount viewAccount;

    private final CategoryService categoryService;
    private final ViewCategory viewCategory;

    private final ProductService productService;
    private final ViewProduct viewProduct;

    public AdminController() {
        scanner = MyScanner.scannerInstance();
        menu = Menu.menuInstance();

        viewAccount = ViewAccount.viewUserInstance();
        userService = UserService.userServiceInstance();

        viewCategory = ViewCategory.viewCategoryInstance();
        categoryService = CategoryService.categoryServiceInstance();

        viewProduct = ViewProduct.viewProduct();
        productService = ProductService.productService();
    }

    public static AdminController adminControllerInstance() {
        if(adminController == null) {
            adminController = new AdminController();
        }
        return adminController;
    }

    public void viewAdmin(String username) {
        int choiceAdmin = 0;
        do {
            menu.viewAdmin();
            try {
                choiceAdmin = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                viewProduct.getErrorEnterStr();
            }
            switch (choiceAdmin) {
                case 1:
                    viewAccount.displayUser(userService.getUserByUserName(username));
                    break;
                case 2:
                    manageAccount(username);
                    break;
                case 3:
                    manageCategory(username);
                    break;
                case 4:
                    manageProduct(username);
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (choiceAdmin != 0);
    }

    private void manageAccount(String username) {
        int choiceAccount = 0;
        do {
            menu.viewAccountManage();
            try {
                choiceAccount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                viewProduct.getErrorEnterStr();
            }
            switch (choiceAccount) {
                case 1:
                    viewAccount.displayUsers(userService.getUsers());
                    break;
                case 2:
                    User user = viewAccount.formCU(new User());
                    user.setRole(viewAccount.getInputRole(user.getId(), "create"));
                    user.setChgWho(username);
                    userService.create(user);
                    break;
                case 3:
                    int id = viewAccount.getInputId();
                    User user1 = userService.getUserById(id);
                    user1 = viewAccount.formCU(user1);
                    user1.setRole(viewAccount.getInputRole(user1.getId(), "update"));
                    user1.setChgWho(username);
                    userService.update(user1);
                    break;
                case 4:
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (choiceAccount != 0);
    }
    private void manageCategory(String username) {
        int choiceCategory = 0;
        do {
            menu.viewCategoryManage();
            try {
                choiceCategory = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                viewProduct.getErrorEnterStr();
            }

            switch (choiceCategory) {
                case 1:
                    viewCategory.displayCategories(categoryService.getCategories());
                    break;
                case 2:
                    Category category = viewCategory.formCU(new Category());
                    category.setChgWho(username);
                    categoryService.create(category);
                    break;
                case 3:
                    Category category1 = viewCategory.formCU(categoryService.getCategoryById(viewCategory.getInputId()));
                    category1.setChgWho(username);
                    categoryService.update(category1);
                    break;
                case 4:
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (choiceCategory != 0);
    }

    private void manageProduct(String username) {
        int choiceProduct = 0;
        do {
            menu.viewProductManage();
            try {
                choiceProduct = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                viewProduct.getErrorEnterStr();
            }
            switch (choiceProduct) {
                case 1:
                    viewProduct.displayProducts(productService.getProducts());
                    break;
                case 2:
                    Product product = viewProduct.formCU(new Product());
                    product.setChgWho(username);
                    productService.create(product);
                    break;
                case 3:
                    Product product1 = viewProduct.formCU(productService.getProductById(viewProduct.getInputId()));
                    product1.setChgWho(username);
                    productService.update(product1);
                    break;
                case 4:
                     Product product2 = viewProduct.formD(productService.getProductById(viewProduct.getInputId()));
                    product2.setChgWho(username);
                    productService.update(product2);
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (choiceProduct != 0);
    }
}
