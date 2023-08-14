public class Main {
    public static void main(String[] args) {
        String str = "kdljgjoigrjojlkjgkdlfjklvd";
        char c = 'k';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                count += 1;
            }
        }
        System.out.println(count);

    }
}