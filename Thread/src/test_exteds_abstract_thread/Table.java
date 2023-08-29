package test_exteds_abstract_thread;

public class Table {
    void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
