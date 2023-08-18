import java.util.EmptyStackException;

public class MyStack<T> {
    private MyLinkedList<T> stack;

    public MyStack() {
        stack = new MyLinkedList<>();
    }

    public void push(T element) {
        stack.addFirst(element);
    }

    public T pop() {
        if(stack.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack.removeFirst();
        }
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        if(stack.size() == 0) {
            return true;
        }
        return false;
    }

    public MyLinkedList<T> getStack() {
        return stack;
    }

    public void setStack(MyLinkedList<T> stack) {
        this.stack = stack;
    }
}
