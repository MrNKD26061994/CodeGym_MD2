package views;

import model.Category;
import service.CategoryService;
import utils.DateUtils;
import utils.MyScanner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ViewCategory extends ViewAbstract{

    private final Scanner scanner;
    private static ViewCategory viewCategory;
    private final CategoryService categoryService;
    public ViewCategory() {
        scanner = MyScanner.scannerInstance();
        categoryService = CategoryService.categoryServiceInstance();

    }
    public static ViewCategory viewCategoryInstance() {
        if(viewCategory == null) {
            viewCategory = new ViewCategory();
        }
        return viewCategory;
    }

    public Category formCU(Category category) {
        String action;
        if(category.getId() != 0) {
            action = "update";
        } else {
            action = "create";
        }
        category.setName(getInputName(category.getName(), action));
        category.setStatus(1);
        category.setChgDate(DateUtils.converter(LocalDateTime.now(), "dd-MM-yyyy HH:mm:ss"));
        return category;
    }

    private String inputId() {
        System.out.print("Enter id: ");
        return scanner.nextLine();
    }

    public int getInputId(){
        do {
            try {
                int id = Integer.parseInt(inputId());
                if(!categoryService.existsById(id)) {
                    System.out.println("Error: Id not exist");
                } else {
                    return id;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter string");
            }
        } while (true);
    }

    public void displayCategories(List<Category> list) {
        System.out.printf("%-5s%-5s%-20s%-20s%-20s%s\n","STT", "Id", "Name", "Repairman", "Update time", "Status");
        for (Category item : list) {
            System.out.printf("%-5d%-5s%-20s%-20s%-20s%s\n", list.indexOf(item) + 1 ,item.getId(), item.getName(), item.getChgWho(), item.getChgDate(), getStringStatus(item.getStatus()));
        }
    }
}
