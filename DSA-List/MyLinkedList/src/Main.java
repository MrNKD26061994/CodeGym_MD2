import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);
        myLinkedList.add(1,50);
        myLinkedList.add(101);
        myLinkedList.addFirst(423432);
        myLinkedList.printList();
        myLinkedList.remove((Integer)50);
        myLinkedList.printList();
        
    }
}