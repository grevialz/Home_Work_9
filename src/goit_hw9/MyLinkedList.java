package goit_hw9;

public class MyLinkedList<E> {

    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    private static class Node<E> {
        E value;
        Node<E> prev = null;
        Node<E> next = null;

        Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public void add(E value) {
        if (tail == null) {
            head = tail = new Node<>(value, null, null);
        } else {
            tail.next = new Node<>(value, tail, null);
            tail = tail.next;
        }
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public E remove(int index) {
        checkIndex(index);
        Node<E> node = getNodeAtIndex(index);

        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        size--;
        return node.value;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> node = getNodeAtIndex(index);
        return node.value;
    }

    private Node<E> getNodeAtIndex(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}