public class MyLinkedList {

    private Node head;
    private int numNodes;

    public MyLinkedList() {}

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
    }

    public void add(Object data) {
        Node temp = head;
        while (temp.next == null) {
            temp = temp.next;
        }
        Node holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private class Node{
        private Node next;
        private final Object data;

        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return this.data;
        }
    }
}
