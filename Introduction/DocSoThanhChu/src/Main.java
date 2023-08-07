import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Nhập số cần đọc: ");
        number = scanner.nextInt();
        int hundreds = number / 100;
        int tens = (number - hundreds * 100) / 10;
        int ten = number - hundreds * 100;
        int ones = number - hundreds * 100 - tens * 10;

        String str1 = switch (hundreds) {
            case 1 -> "One hundred";
            case 2 -> "Two hundred";
            case 3 -> "Three hundred";
            case 4 -> "Four hundred";
            case 5 -> "Five hundred";
            case 6 -> "Six hundred";
            case 7 -> "Seven hundred";
            case 8 -> "Eight hundred";
            case 9 -> "Nine hundred";
            default -> "";
        };

        String str2 = switch (tens) {
            case 1 -> {
                String res = "";
                switch (ten) {
                    case 10 -> res = "ten";
                    case 11 -> res = "eleven";
                    case 12 -> res = "twelve";
                    case 13 -> res = "thirteen";
                    case 14 -> res = "fourteen";
                    case 15 -> res = "fifteen";
                    case 16 -> res = "sixteen";
                    case 17 -> res = "seventeen";
                    case 18 -> res = "eighteen";
                    case 19 -> res = "nineteen";
                }
                yield res;
            }
            case 2 -> "twenty ";
            case 3 -> "thirty ";
            case 4 -> "forty ";
            case 5 -> "fifty ";
            case 6 -> "sixty ";
            case 7 -> "seventy ";
            case 8 -> "eighty ";
            case 9 -> "ninety ";
            default -> "";
        };

        String str3 = switch (ones) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "";
        };

        String result = "";
        if(tens == 1){
            str3 = "";
        }
        if(!str1.isEmpty() && ten != 0) {
            result = str1 + " and ";
        }
        result += str2 + str3;
        System.out.println(result);
    }
}