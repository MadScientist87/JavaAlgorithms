package Threading;

import java.util.ArrayList;
import java.util.List;

public class SimpleThread {
    ArrayList<Thread> threads = new ArrayList<Thread>();
    public static void createThread(){

        Thread thread = new NewThread();

        thread.start();


    }
    public void MultiExecutor(List<Runnable> tasks) {
        // Complete your code here
        for(Runnable task:tasks){
            threads.add(new Thread(task));
        }

    }
    private static class NewThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }
}
