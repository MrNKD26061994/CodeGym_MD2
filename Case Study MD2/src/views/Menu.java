package views;

public class Menu {

    private static Menu menu;
    public static Menu menuInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }
    public void viewHome() {
        System.out.println("MENU");
        System.out.println("1: Login");
        System.out.println("2: Register");
        System.out.println("3: Shop");
        System.out.println("9: Exit");
        System.out.println("Enter your choice: ");
    }

    public void viewAdmin() {
        System.out.println("MENU ADMIN");
        System.out.println("1: Personal information");
        System.out.println("2: Manage Users");
        System.out.println("3: Manage Categories");
        System.out.println("4: Manage Products");
        System.out.println("5: Manage Carts");
        System.out.println("9: Exit");
        System.out.println("0: Home");
        System.out.println("Enter your choice: ");
    }

    public void viewCustomer() {
        System.out.println("MENU USER");
        System.out.println("1: Personal information");
        System.out.println("2: View Categories");
        System.out.println("3: View Products");
        System.out.println("4: View Cart");
        System.out.println("5: View Bills");
        System.out.println("9: Exit");
        System.out.println("0: Home");
        System.out.println("Enter your choice: ");
    }

    public void viewAccountManage() {
        System.out.println("MENU CUSTOMER MANAGE");
        viewCRU();
        System.out.println("4: Delete");
        System.out.println("9: Exit");
        System.out.println("0: Menu ADMIN");
        System.out.println("Enter your choice: ");
    }

    public void viewProductManage() {
        System.out.println("MENU PRODUCT MANAGE");
        viewCRU();
        System.out.println("4: Delete");
        System.out.println("9: Exit");
        System.out.println("0: Menu ADMIN");
        System.out.println("Enter your choice: ");
    }

    public void viewCategoryManage() {
        System.out.println("MENU CATEGORY MANAGE");
        viewCRU();
        System.out.println("4: Delete");
        System.out.println("9: Exit");
        System.out.println("0: Menu ADMIN");
        System.out.println("Enter your choice: ");
    }

    private void viewCRU() {
        System.out.println("1: List");
        System.out.println("2: Create");
        System.out.println("3: Update");
    }

    public void viewCartNotPay() {
        System.out.println("1: Add Product");
        System.out.println("2: Plus Product By Cart");
        System.out.println("3: Sub Product By Cart");
        System.out.println("4: Delete By Product");
        System.out.println("5: Payment");
        System.out.println("0: Back");
        System.out.println("Enter your choice: ");
    }
}
