import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> myStackInteger = new MyStack<>();
        myStackInteger.push(5);
        myStackInteger.push(4);
        myStackInteger.push(3);
        myStackInteger.push(2);
        myStackInteger.push(1);
        System.out.println("2.1. Size of stack after push operations: " + myStackInteger.size());
        System.out.println("2.2. Pop elements from stack : ");
        while (!myStackInteger.isEmpty()) {
            System.out.printf("%d ", myStackInteger.pop());
        }
        System.out.println("\n3.3 Size of stack after pop operations : " + myStackInteger.size());


        MyStack<String> myStackString = new MyStack<>();
        myStackString.push("Five");
        myStackString.push("Four");
        myStackString.push("Three");
        myStackString.push("Two");
        myStackString.push("One");
        System.out.println("1.1 Size of stack after push operations: " + myStackString.size());
        System.out.println("1.2. Pop elements from stack : ");
        while (!myStackString.isEmpty()) {
            System.out.printf("%s ", myStackString.pop());
        }
        System.out.println("\n1.3. Size of stack after pop operations : " + myStackString.size());
    }
}