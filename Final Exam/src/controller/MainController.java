package controller;

import model.Product;
import service.ProductService;
import util.MyScanner;
import view.ViewMenu;
import view.ViewProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private ViewMenu viewMenu;
    private Scanner scanner;

    private ViewProduct viewProduct;
    private ProductService productService;

    public MainController() {
        viewMenu = new ViewMenu();
        scanner = MyScanner.scannerInstance();
        viewProduct = ViewProduct.viewProductInstance();
        productService = ProductService.productServiceInstance();
    }

    public void start() {
        int choiceHome = 0;
        do {
            viewMenu.viewHome();
            try {
                choiceHome = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter string");
            }
            switch (choiceHome) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    create();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                case 5:
                    sort();
                    break;
                case 6:
                    searchProductMax();
                    break;
                case 9:
                    break;
            }
        } while (choiceHome != 0);
    }

    private void searchProductMax() {
        Product productMax = productService.getProductMax();
        viewProduct.displayProduct(productMax);
    }

    private void sort() {
        List<Product> listProduct = new ArrayList<>(productService.getProducts());
        listProduct.sort((o1, o2) -> o1.getPrice() - o2.getPrice());
        viewProduct.displayProducts(listProduct);
    }

    private void delete() {
        Product product = productService.getProductByCode(viewProduct.getInputCode("update"));
        String chose;
        System.out.print("Bạn có muốn xóa Y/N");
        chose = scanner.nextLine();
        if(chose.equals("Y")){
            productService.delete(product);
        }
    }

    private void update() {
        Product product = viewProduct.formCU(productService.getProductByCode(viewProduct.getInputCode("update")));
        productService.update(product);
    }

    private void displayProducts() {
        viewProduct.displayProducts(productService.getProducts());
    }

    private void create() {
        Product product = viewProduct.formCU(new Product());
        productService.create(product);
    }
}
