package goit_hw9;

public class MyHashMap<K, V> {

    private Node<K, V>[] table;
    private int capacity;
    private int size;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_CAPACITY = 16;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        table = new Node[capacity];
    }

    public void put(K key, V value) {
        if (size >= LOAD_FACTOR * capacity) {
            resize();
        }

        int hash = hash(key);
        Node<K, V> node = new Node<>(key, value);

        if (table[hash] == null) {
            table[hash] = node;
            size++;
        } else {
            Node<K, V> current = table[hash];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = node;
                size++;
            }
        }
    }

    public V get(K key) {
        int hash = hash(key);
        Node<K, V> current = table[hash];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public V remove(K key) {
        int hash = hash(key);
        Node<K, V> current = table[hash];
        Node<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[hash] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }

        return null;
    }

    public void clear() {
        table = new Node[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        capacity *= 2;
        Node<K, V>[] newTable = new Node[capacity];

        for (Node<K, V> node : table) {
            while (node != null) {
                Node<K, V> next = node.next;
                int hash = hash(node.key);
                node.next = newTable[hash];
                newTable[hash] = node;
                node = next;
            }
        }

        table = newTable;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        } else {
            return Math.abs(key.hashCode() % capacity);
        }
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}