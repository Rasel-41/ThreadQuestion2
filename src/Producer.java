import java.util.Random;

public class Producer implements Runnable{
    private final Stack stack;
    private final Random random = new Random();
    public Producer(Stack stack){
        this.stack = stack;

    }
    public void run(){
        try{
            for(int i=0;i<100;i++){
                int value = random.nextInt()+1;
                stack.push(value);
                System.out.println("Produced: "+value);
                Thread.sleep(50);
            }
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
