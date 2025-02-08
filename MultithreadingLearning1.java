public class MultithreadingLearning1 implements Runnable {

    @Override
    public void run() {
        System.out.println("code executed by thread: " + Thread.currentThread().getName());
    }
}