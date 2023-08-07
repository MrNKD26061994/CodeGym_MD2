public class Main {
    public static void main(String[] args) {
        System.out.print(2);
        for (int i = 3; i < 100; i++){
            boolean checkSNT = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    checkSNT = true;
                    break;
                }
            }
            if (!checkSNT) {
                System.out.print(" " + i);
            }
        }
    }
}