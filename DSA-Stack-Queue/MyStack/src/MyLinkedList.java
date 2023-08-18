public class MyLinkedList<T> {

    private Node<T> head;
    private int numNodes;

    public MyLinkedList() {}

    public MyLinkedList(T data) {
        head = new Node<T>(data);
    }

    public boolean isEmpty(){
        if(head == null)return true;
        return false;
    }

    public int size() {
        return numNodes;
    }

    public void add(int index, T data) {
        Node<T> temp = head;
        Node<T> tempNode = new Node<T>();
        tempNode.setData(data);
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        tempNode.next = temp.next;
        temp.next = tempNode;
        numNodes++;
    }

    public void add(T data) {
        addLast(data);
    }

    public void addFirst(T data) {
        Node<T> temp = head;
        Node<T> tempNode = new Node<T>();
        tempNode.setData(data);
        head = tempNode;
        head.next = temp;
        numNodes++;
    }

    public void addLast(T data) {
        Node<T> tempNode = new Node<T>();
        tempNode.setData(data);
        tempNode.next = null;
        if(isEmpty()) {
            head = tempNode;
            numNodes++;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = tempNode;
            numNodes++;
        }
    }

    public void remove(){
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        numNodes--;
    }
    public void remove(T data){
        Node<T> temp = head;
        if(head.getData().equals(data)) {
            head = temp.next;
            temp.next = null;
        } else {
            while (temp.next != null){
                if(temp.next.getData() == data){
                    Node<T> tempNode = temp.next;
                    temp.next = temp.next.next;
                    tempNode.next = null;
                    break;
                }
                temp = temp.next;
            }
        }
        numNodes--;
    }
    public void remove(int index) {
        Node<T> temp = head;
        if(index == 0) {
            head = temp.next;
            temp.next = null;
        }else {
            for (int i = 0; temp.next != null; i++) {
                if(i == index - 1){
                    Node<T> tempNode = temp.next;
                    temp.next = temp.next.next;
                    tempNode.next = null;
                    break;
                }
                temp=temp.next;
            }
        }
        numNodes--;
    }
    public T removeFirst() {
        Node<T> temp = head;
        head = temp.next;
        temp.next = null;
        numNodes--;
        return (T) temp.getData();
    }
    public T removeLast() {
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        numNodes--;
        return (T) temp.getData();
    }

    public T getFirst() {
        return head.getData();
    }

    public T getLast() {
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        return (T) temp.getData();
    }


    public void printList() {
        Node<T> temp = head;
        while (temp!= null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }

    public Node<T> get(int index) {
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private class Node<T>{
        private Node<T> next;
        private T data;

        public Node() {
        }
        public Node(T data) {
            this.data = data;
        }
        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
