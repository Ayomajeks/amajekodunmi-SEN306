import java.util.ArrayList;
import java.util.List;

interface QueueADT {
    void enqueue(int element);
    int dequeue();
    boolean isEmpty();
    int size();
}

class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}


class LinkedQueue implements QueueADT {
    private Node head;
    private Node tail;
    private int count;

    @Override
    public void enqueue(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Empty");
        int value = head.data;
        head = head.next;
        if (head == null) tail = null;
        count --;
        return value;
    }

    @Override
    public boolean isEmpty() { return count == 0; }

    @Override
    public int size() { return count; }
}

public class Main2 {
    public static void main(String[] args) {
        QueueADT queue = new ArrayListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue());
    }
}