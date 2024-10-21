import java.util.LinkedList;

public class Stack {
    private final LinkedList<Integer> stack = new LinkedList<>();
    private final int Limit = 10;

    public synchronized void push(int value) throws InterruptedException {
        while (stack.size() == Limit) {
            wait();
        }
        stack.push(value);
        notifyAll();
    }

    public synchronized int pop() throws InterruptedException {
        while (stack.isEmpty()) {
            wait();
        }
        int value = stack.pop();
        notifyAll();
        return value;

    }
}
