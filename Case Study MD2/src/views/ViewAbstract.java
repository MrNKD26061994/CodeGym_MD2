package views;

import utils.MyScanner;

import java.util.Scanner;

public class ViewAbstract {
    private final Scanner scanner;

    public ViewAbstract() {
        scanner = MyScanner.scannerInstance();
    }

    protected String getInputName(String name, String action) {
        do {
            String nameTemp = inputName();
            if(nameTemp.isEmpty()) {
                if (action.equals("create")) {
                    System.out.println("Error: No name Entered");
                } else {
                    return name;
                }
            } else {
                return nameTemp;
            }
        } while (true);
    }

    private String inputName() {
        System.out.print("Enter name: ");
        return scanner.nextLine();
    }

    protected String getStringStatus(int status) {
        if(status == 1) {
            return "EXIST";
        } else {
            return "NOT EXIST";
        }
    }

    public void getErrorEnterStr() {
        System.out.println("Error: Enter string");
    }

    public void getQuoteLine() {
        System.out.println("Enter your choice: ");
    }

    public void displayLinePrivate() {
        System.out.println("0 Private");
    }
}
