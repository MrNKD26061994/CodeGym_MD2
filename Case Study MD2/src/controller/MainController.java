package controller;

import model.User;
import service.UserService;
import utils.MyScanner;
import views.Menu;
import views.ViewAccount;

import java.util.Scanner;

public class MainController {
    private final Scanner scanner;
    public Menu menu;
    private final UserService userService;
    private final ViewAccount viewAccount;
    private final AdminController adminController;
    private final CustomerController customerController;

    public MainController() {
        scanner = MyScanner.scannerInstance();
        menu = Menu.menuInstance();

        userService = UserService.userServiceInstance();
        viewAccount = ViewAccount.viewUserInstance();

        adminController = AdminController.adminControllerInstance();
        customerController = CustomerController.customerControllerInstance();
    }

    public void start() {
        int choiceHome = 0;
        while (choiceHome != -1) {
            menu.viewHome();
            try {
                choiceHome = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter string");
            }
            switch (choiceHome) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 9:
                    choiceHome = -1;
                    break;
            }
        }
    }

    private void register() {
        User user = viewAccount.formCU(new User());
        userService.create(user);
    }

    private void login() {
        User user = viewAccount.formLogin();
        if(userService.login(user) == 1) {
            adminController.viewAdmin(user.getUsername());
        } else if(userService.login(user) == 0) {
            customerController.viewCustomer(user.getUsername());
        } else {
            viewAccount.userOrPassError();
        }
    }
}
