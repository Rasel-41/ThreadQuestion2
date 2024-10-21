public class Runner {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Thread producerThread = new Thread(new Producer(stack));
        Thread consumerThread = new Thread(new Consumer(stack));
        producerThread.start();
        consumerThread.start();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
