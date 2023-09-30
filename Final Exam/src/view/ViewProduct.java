package view;

import model.Product;
import service.ProductService;
import util.MyScanner;

import java.util.List;
import java.util.Scanner;

public class ViewProduct extends ViewAbstract {
    private static ViewProduct viewProductInstance;
    private Scanner scanner;

    private ProductService productService;

    public ViewProduct() {
        scanner = MyScanner.scannerInstance();
        productService = ProductService.productServiceInstance();
    }
    public static ViewProduct viewProductInstance() {
        if(viewProductInstance == null) {
            viewProductInstance = new ViewProduct();
        }
        return viewProductInstance;
    }



    private String inputId() {
        System.out.print("Enter id: ");
        return scanner.nextLine();
    }

    public Product formCU(Product product) {
        String action;
        if(product.getId() != 0) {
            action = "update";
        } else {
            action = "create";
        }
        product.setCode(getInputCode(action));
        product.setName(getInputName(product.getName(), action));
        product.setPrice(getInputPrice(product.getPrice(), action));
        product.setQuantity(getInputQuantity(product.getQuantity(), action));
        product.setDescription(getInputDescription(product.getDescription(), action));
        return product;
    }

    public String getInputDescription(String description, String action) {
        do {
            String descriptionTemp = inputDescription();
            if(descriptionTemp.isEmpty()) {
                if (action.equals("create")) {
                    System.out.println("Error: No description Entered");
                } else {
                    return description;
                }
            } else {
                return descriptionTemp;
            }
        } while (true);
    }
    private String inputDescription() {
        System.out.print("Enter description: ");
        return scanner.nextLine();
    }

    private int getInputPrice(int price, String action) {
        do {
            String priceStr = inputPrice();
            if (priceStr.isEmpty()){
                if(action.equals("create")){
                    System.out.println("Error: No price Entered");
                } else {
                    return price;
                }
            } else {
                try {
                    int priceTemp = Integer.parseInt(priceStr);
                    if(priceTemp < 0) {
                        System.out.println("Error: Price is less than 0");
                    } else {
                        return priceTemp;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Enter string");
                }
            }
        } while (true);
    }
    private String inputPrice() {
        System.out.print("Enter price: ");
        return scanner.nextLine();
    }

    private int getInputQuantity(int quantity, String action) {
        do {
            String quantityStr = inputQuantity();
            if (quantityStr.isEmpty()){
                if(action.equals("create")){
                    System.out.println("Error: No quantity Entered");
                } else {
                    return quantity;
                }
            } else {
                try {
                    int quantityTemp = Integer.parseInt(quantityStr);
                    if(quantityTemp < 0) {
                        System.out.println("Error: Quantity is less than 0");
                    } else {
                        return quantityTemp;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Enter string");
                }
            }
        } while (true);
    }
    private String inputQuantity() {
        System.out.print("Enter quantity: ");
        return scanner.nextLine();
    }

    public String inputCode() {
        System.out.print("Enter code: ");
        return scanner.nextLine();
    }
    public String getInputCode(String action) {
        do {
            String codeTemp = inputCode();
            if(codeTemp.isEmpty()) {
                System.out.println("Error: No code Entered");
            } else {
                if(productService.existsByCode(codeTemp)) {
                    if(action.equals("create")) {
                        System.out.println("Error: Code exist");
                    } else {
                        return codeTemp;
                    }
                } else {
                    return codeTemp;
                }
            }
        } while (true);
    }

    public void displayProducts(List<Product> list) {
        System.out.printf("%-20s%-20s%-20s%-20s%s\n", "Code", "Name", "Price", "Quantity", "Description");
        for (Product item : list) {
            System.out.printf("%-20s%-20s%-20d%-20d%s\n", item.getCode(), item.getName(), item.getPrice(), item.getQuantity(), item.getDescription());
        }
    }

    public void displayProduct(Product product) {
        System.out.printf("%-20s%-20s%-20s%-20s%s\n", "Code", "Name", "Price", "Quantity", "Description");
        System.out.printf("%-20s%-20s%-20d%-20d%s\n", product.getCode(), product.getName(), product.getPrice(), product.getQuantity(), product.getDescription());
    }
}
