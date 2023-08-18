import java.util.Arrays;

public class ReverseByStack {

    public static void main(String[] args) {
        MyStack<Integer> intStack = new MyStack<>();
        int[] arrInt = {4,2,6,3,7,3,7,5,4,8};
        System.out.println(Arrays.toString(arrInt));
        for (int item : arrInt) {
            intStack.push(item);
        }

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = intStack.pop();
        }
        System.out.println(Arrays.toString(arrInt));

        MyStack<String> stringStack = new MyStack<>();
        String str = "dsj fklj lkwj oisd oie wur oi";
        String[] arrStr = str.split(" ");
        System.out.println(Arrays.toString(arrStr));
        for (int i = 0; i < arrStr.length; i++) {
            stringStack.push(arrStr[i]);
        }

        for (int i = 0; i < arrStr.length; i++) {
            arrStr[i] = stringStack.pop();
            str.concat(arrStr[i]);
        }
        System.out.println(str);
    }
}
