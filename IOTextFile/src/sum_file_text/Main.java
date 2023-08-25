package sum_file_text;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);

//        Url path: src/sum_file_text/test.txt
        String path = scanner.nextLine();

        ReadFileExample readFile = new ReadFileExample();
        readFile.readFileText(path);
    }
}
