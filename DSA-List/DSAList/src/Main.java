import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyList<String> listInteger = new MyList<String>();
        listInteger.add("1");
        listInteger.add("2");
        listInteger.add("3");
        listInteger.add("3");
        listInteger.add("4");
        String[] a = new String[1];

        System.out.println("element 4: " + listInteger.get(4));
        System.out.println("element 1: " + listInteger.get(1));
        System.out.println("element 2: " + listInteger.get(2));

//        listInteger.get(6);
//        System.out.println("element 6: " + listInteger.get(6));

//        listInteger.get(-1);
//        System.out.println("element 6: " + listInteger.get(-1));
    }
}