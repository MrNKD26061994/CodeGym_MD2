package views;

import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;
import utils.DateUtils;
import utils.MyScanner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ViewProduct extends ViewAbstract {

    private static ViewProduct viewProduct;
    private final Scanner scanner;

    private final CategoryService categoryService;
    private final ProductService productService;
    public ViewProduct() {
        scanner = MyScanner.scannerInstance();
        categoryService = CategoryService.categoryServiceInstance();
        productService = ProductService.productService();
    }

    public static ViewProduct viewProduct() {
        if(viewProduct == null) {
            viewProduct = new ViewProduct();
        }
        return viewProduct;
    }

    public Product formCU(Product product) {
        String action;
        if(product.getId() != 0) {
            action = "update";
        } else {
            action = "create";
        }
        product.setName(getInputName(product.getName(), action));
        product.setCategory(getInputCategory(product.getCategory(),action));
        product.setQuantity(getInputQuantity(product.getQuantity(),action));
        product.setDescription(getInputDescription(product.getDescription(), action));
        product.setPrice(getInputPrice(product.getPrice(), action));
        product.setStatus(1);
        product.setChgDate(DateUtils.converter(LocalDateTime.now(), "dd-MM-yyyy HH:mm:ss"));
        return product;
    }

    public Product formD(Product product) {
        product.setStatus(0);
        product.setChgDate(DateUtils.converter(LocalDateTime.now(), "dd-MM-yyyy HH:mm:ss"));
        return product;
    }

    private String inputId() {
        System.out.print("Enter id: ");
        return scanner.nextLine();
    }

    public int getInputId(){
        do {
            try {
                int id = Integer.parseInt(inputId());
                if(!productService.existsById(id)) {
                    System.out.println("Error: Id not exist");
                } else {
                    return id;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter string");
            }
        } while (true);
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

    private Category getInputCategory(Category category, String action) {
        do {
            String idCategoryStr = inputIdCategory();
            if(idCategoryStr.isEmpty()) {
                if(action.equals("create")) {
                    System.out.println("Error: No categoryID Entered");
                } else {
                    return category;
                }
            } else {
                try {
                    int idCategory = Integer.parseInt(idCategoryStr);
                    if (!categoryService.existsById(idCategory)) {
                        System.out.println("Error: Id not exist");
                    } else {
                        return categoryService.getCategoryById(idCategory);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Enter string");
                }
            }
        } while (true);
    }

    private String inputIdCategory() {
        System.out.print("Enter idCategory: ");
        return scanner.nextLine();
    }

    public void displayProducts(List<Product> list) {
        System.out.printf("%-5s%-5s%-20s%-20s%-12s%-12s%-12s%-12s%s\n", "STT", "ID", "Name", "Name Category", "Price", "Quantity", "ChgWho", "Status", "Description");
        for (Product item : list) {
            System.out.printf("%-5d%-5d%-20s%-20s%-12d%-12d%-12s%-12s%s\n",list.indexOf(item) + 1 ,item.getId(), item.getName(), item.getCategory().getName(), item.getPrice(), item.getQuantity(), item.getChgWho(), getStringStatus(item.getStatus()), item.getDescription());
        }
    }

}
