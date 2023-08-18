public class MyLinkedList {

    private Node head;
    private int numNodes;

    public MyLinkedList() {}

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    public boolean isEmpty(){
        if(head == null)return true;
        return false;
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node tempNode = new Node();
        tempNode.setData(data);
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        tempNode.next = temp.next;
        temp.next = tempNode;
        numNodes++;
    }

    public void add(Object data) {
        addLast(data);
    }

    public void addFirst(Object data) {
        Node temp = head;
        Node tempNode = new Node();
        tempNode.setData(data);
        head = tempNode;
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object data) {
        Node tempNode = new Node();
        tempNode.setData(data);
        tempNode.next = null;
        if(isEmpty()) {
            head = tempNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = tempNode;
            numNodes++;
        }
    }

    public void remove(){
        removeLast();
    }
    public void remove(Object data){
        if(head.getData().equals(data)) {
            removeFirst();
        } else {
            Node temp = head;
            while (temp.next != null){
                if(temp.next.getData() == data){
                    Node tempNode = temp.next;
                    temp.next = temp.next.next;
                    tempNode.next = null;
                    break;
                }
                temp = temp.next;
            }
        }
    }
    public void remove(int index) {
        if(index == 0) {
            removeFirst();
        }else {
            Node temp = head;
            for (int i = 0; temp.next != null; i++) {
                if(i == index - 1){
                    Node tempNode = temp.next;
                    temp.next = temp.next.next;
                    tempNode.next = null;
                    break;
                }
                temp=temp.next;
            }
        }
    }
    public void removeFirst() {
        Node temp = head;
        head = temp.next;
        temp.next = null;
    }
    public void removeLast() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }


    public void printList() {
        Node temp = head;
        while (temp!= null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }
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
        private Object data;

        public Node() {
        }
        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return this.data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
