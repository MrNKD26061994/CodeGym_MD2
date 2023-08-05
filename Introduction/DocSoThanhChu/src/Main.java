import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Nhập số cần đọc: ");
        number = scanner.nextInt();
        int hundreds = number / 100;
        int tens = (number - hundreds * 100) / 10;
        int ones = number - hundreds * 100 - tens * 10;
        String result = "";
        if(number > 999 || number <= 0) {
            result += "Số nhâp phải lớn hơn 0 hoặc nhỏ hơn 999";
        } else {
            if(hundreds != 0) {
                result += stringHundred(hundreds);
                if(tens != 0) {
                    result += " and ";
                    if(tens == 1) {
                        result += stringTeen(number - hundreds * 100);
                    } else {
                        result += stringTens(tens) + " " + stringOnes(ones);
                    }
                } else {
                    if(ones != 0) {
                        result += " and ";
                        result += stringOnes(ones);
                    }
                }
            } else {
                if(tens != 0) {
                    if(tens == 1) {
                        result += stringTeen(number - hundreds * 100);
                    } else {
                        result += stringTens(tens) + " " + stringOnes(ones);
                    }
                } else {
                    if(ones != 0) {
                        result += stringOnes(ones);
                    }
                }
            }
        }

        System.out.println(result);
    }
    public static String stringOnes(int ones) {
        switch (ones) {
            case 0 -> {
                return "";
            }
            case 1 -> {
                return "one";
            }
            case 2 -> {
                return "two";
            }
            case 3 -> {
                return "three";
            }
            case 4 -> {
                return "four";
            }
            case 5 -> {
                return "five";
            }
            case 6 -> {
                return "six";
            }
            case 7 -> {
                return "seven";
            }
            case 8 -> {
                return "eight";
            }
            case 9 -> {
                return "nine";
            }
            default -> {
                return "Out of ability";
            }
        }
    }

    public static String stringTeen(int teen) {
        switch (teen) {
            case 10 -> {
                return "ten";
            }
            case 11 -> {
                return "eleven";
            }
            case 12 -> {
                return "twelve";
            }
            case 13 -> {
                return "thirteen";
            }
            case 14 -> {
                return "fourteen";
            }
            case 15 -> {
                return "fifteen";
            }
            case 16 -> {
                return "sixteen";
            }
            case 17 -> {
                return "seventeen";
            }
            case 18 -> {
                return "eighteen";
            }
            case 19 -> {
                return "nineteen";
            }
            default -> {
                return "Out of ability";
            }
        }
    }

    public static String stringTens(int tens) {
        switch (tens) {
            case 2 -> {
                return "twenty";
            }
            case 3 -> {
                return "thirty";
            }
            case 4 -> {
                return "forty";
            }
            case 5 -> {
                return "fifty";
            }
            case 6 -> {
                return "sixty";
            }
            case 7 -> {
                return "seventy";
            }
            case 8 -> {
                return "eighty";
            }
            case 9 -> {
                return "ninety";
            }
        }
        return "";
    }

    public static String stringHundred(int hundred) {
        switch (hundred) {
            case 1 -> {
                return "One hundred";
            }
            case 2 -> {
                return "Two hundred";
            }
            case 3 -> {
                return "Three hundred";
            }
            case 4 -> {
                return "Four hundred";
            }
            case 5 -> {
                return "Five hundred";
            }
            case 6 -> {
                return "Six hundred";
            }
            case 7 -> {
                return "Seven hundred";
            }
            case 8 -> {
                return "Eight hundred";
            }
            case 9 -> {
                return "Nine hundred";
            }
        }
        return "";
    }
}