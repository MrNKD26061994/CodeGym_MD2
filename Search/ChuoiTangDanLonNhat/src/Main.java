import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String str = scanner.nextLine();
        System.out.print(stringSearchUp(removeDuplicateCharacters(str)));
    }
    static String[] sortString(String[] arrString) {
        for (int i = 0; i < arrString.length - 1; i++) {
            String min = arrString[i];
            for (int j = i; j < arrString.length; j++) {
                if(min.compareTo(arrString[j]) > 0) {
                    String t = min;
                    arrString[i] = arrString[j];
                    arrString[j] = t;
                }
            }
        }
        return arrString;
    }
    static String stringSearchUp(String str) {
        String[] arrStr = str.split("");
        return String.join("", sortString(arrStr));
    }
    static boolean sequentialSearch(String str, char c) {
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c){
                return true;
            }
        }
        return false;
    }
    static String removeDuplicateCharacters(String str) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if(!sequentialSearch(temp,str.charAt(i))) {
                temp += str.charAt(i);
            }
        }
        return temp;
    }
}