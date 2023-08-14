package goit_hw9;

public class MyArrayList<T> {
    private T[] array;
    private int size;
    private static final int DEFAUlT_SIZE = 10;

    public MyArrayList() {
        array = (T[]) new Object[DEFAUlT_SIZE];
        size = 0;
    }

    public void add(T value) {
        if (size >= array.length) {
            ensureCapacity(array.length * 2);
        }
        array[size] = value;
        size++;
    }

    public T remove(int index) {
        checkIndex(index);
        T removed = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removed;
    }

    public void clear() {
        array = (T[]) new Object[DEFAUlT_SIZE];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            T[] newArray = (T[]) new Object[minCapacity];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}