import goit_hw9.*;

public class Main {
    public static void main(String[] args) {
        // testing myArrayList
        System.out.println("\t testing myArrayList");
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            myArrayList.add(i);
        }
        System.out.println("myArrayList.get(0) = " + myArrayList.get(0));

        System.out.println("size = " + myArrayList.size());

        myArrayList.remove(0);
        System.out.println("size after remove = " + myArrayList.size());

        myArrayList.clear();
        System.out.println("size after clear = " + myArrayList.size());

        // testing myHashMap
        System.out.println("\t testing myHashMap");
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 1_000_000; i++) {
            myHashMap.put(i, i);
        }

        myHashMap.remove(0);
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap.get(0) = " + myHashMap.get(0));
        myHashMap.clear();
        System.out.println("myHashMap.size() = " + myHashMap.size());

        //testing MyLinkedList
        System.out.println("\t testing MyLinkedList");
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 1_000_000; i++) {
            myLinkedList.add(i);
        }
        myLinkedList.remove(0);

        System.out.println("myLinkedList.size() = " + myLinkedList.size());

        System.out.println("myLinkedList.get(0) = " + myLinkedList.get(0));

        myLinkedList.clear();

        //testing MyQueue
        System.out.println("\t testing MyQueue");
        MyQueue<Integer> myQueue = new MyQueue<>();
        for (int i = 0; i < 1_000_000; i++) {
            myQueue.add(i);
        }

        System.out.println("myQueue.poll() = " + myQueue.poll());

        System.out.println("myQueue.peek() = " + myQueue.peek());

        System.out.println("myQueue.size() = " + myQueue.size());

        myQueue.clear();

        //testing MyStack
        System.out.println("\t testing MyStack");
        MyStack<Integer> myStack = new MyStack<>();
        for (int i = 0; i < 1_000_000; i++) {
            myStack.push(i);
        }

        System.out.println("myStack.peek() = " + myStack.peek());

        System.out.println("myStack.pop() = " + myStack.pop());

        myStack.remove(0);

        System.out.println("myStack.size() = " + myStack.size());

        myStack.clear();
    }
}