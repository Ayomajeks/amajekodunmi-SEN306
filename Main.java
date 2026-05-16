import java.util.ArrayList;
import java.util.List;

interface QueueADT {
    void enqueue(int element);
    int dequeue();
    boolean isEmpty();
    int size();
}

class ArrayListQueue implements QueueADT {
    private List<Integer> list = new ArrayList<>();

    @Override
    public void enqueue(int element) {
        list.add(element);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return list.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}

public class Main {
    public static void main(String[] args) {
        QueueADT queue = new ArrayListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue());
    }
}