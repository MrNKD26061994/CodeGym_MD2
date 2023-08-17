public class FizzBuzz {
    int number;

    public FizzBuzz(int number) {
        this.number = number;
    }

    public String checkFizzBuzz() {
        if(number == 53) {
            return "BuzzFizz";
        } else if(number == 35) {
            return "FizzBuzz";
        }
        if(number % 3 == 0 && number % 5 == 0) return "FizzBuzz";
        else if(number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            int chuc = number / 10;
            int dv = number - (chuc * 10);
            if(chuc == 3 || dv == 3) {
                return "Fizz";
            } else if(chuc == 5) {
                return "Buzz";
            } else {
                return  docNum(chuc) + " " + docNum(dv);
            }
        }
    }
    public String docNum(int num) {
        return switch (num) {
            case 1 -> "một";
            case 2 -> "hai";
            case 3 -> "ba";
            case 4 -> "bốn";
            case 5 -> "năm";
            case 6 -> "sáu";
            case 7 -> "bảy";
            case 8 -> "tám";
            case 9 -> "chín";
            default -> "";
        };
    }
}
