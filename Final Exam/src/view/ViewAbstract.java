package view;

import util.MyScanner;

import java.util.Scanner;

public class ViewAbstract {
    private final Scanner scanner;

    public ViewAbstract() {
        scanner = MyScanner.scannerInstance();
    }

    private String inputName() {
        System.out.print("Enter name: ");
        return scanner.nextLine();
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
    public void getErrorEnterStr() {
        System.out.println("Error: Enter string");
    }
}
