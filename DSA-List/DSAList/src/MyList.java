import java.util.ArrayList;
import java.util.Arrays;

public class MyList<T> {
    private int size;
    final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements =  new Object[DEFAULT_CAPACITY];
    }

    public void add(T value) {
        if(size == elements.length){
            ensureCapa();
        }
        elements[size++] = value;
    }

    public void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public T get(int i) {
        if(i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size " + i);
        }
        return (T) elements[i];
    }
}
