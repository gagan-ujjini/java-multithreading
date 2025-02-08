public class Main {
    public static void main(String[] args) {
        System.out.println("Inside main method: " + Thread.currentThread().getName());
        MultithreadingLearning1 runnableObject = new MultithreadingLearning1();
        Thread thread = new Thread(runnableObject);
        thread.start(); // This will internally call the run method of therunnableObject
        System.out.println("Finishing main method: " + Thread.currentThread().getName());

        System.out.println("========================================================");
        System.out.println("========================================================");

        /* OUTPUT of above code */
        // Inside main method: main
        // Finishing main method: main
        // code executed by thread: Thread-0

        MultithreadingLearning2 mythread = new MultithreadingLearning2();
        mythread.start(); // This will internally call the run method of the mythread
        System.out.println("Finishing main method: " + Thread.currentThread().getName());

        System.out.println("========================================================");
        System.out.println("========================================================");

        /* OUTPUT of above code */
        // Inside main method: main
        // Finishing main method: main
        // code executed by thread: Thread-0
        // Finishing main method: main
        // code executed by thread: Thread-1

        /* MONITOR LOCK EXAMPLE */
        MonitorLockExample obj = new MonitorLockExample();

        // creating lambda expressions to create threads
        Thread t1 = new Thread(() -> {
            obj.task1();
        });
        Thread t2 = new Thread(() -> {
            obj.task2();
        });
        Thread t3 = new Thread(() -> {
            obj.task3();
        });

        t1.start();
        t2.start();
        t3.start();

        // OUTPUT of above code
        // Inside task1
        // task3
        // task2, but before synchronized block
        // task2, inside synchronized block //last two lines will be print after 10
        // seconds

        System.out.println("========================================================");
        System.out.println("========================================================");

        /* PRODUCER CONSUMER EXAMPLE */
        System.out.println("Main method start");
        SharedResource sharedResource = new SharedResource();

        // producer thread
        Thread producerThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                // handle exception here
            }
            sharedResource.addItem();
        });

        // consumer thread
        Thread consumerThread = new Thread(() -> {
            sharedResource.consumeItem();
        });

        // thread is in "Runnable" state
        producerThread.start();
        consumerThread.start();

        System.out.println("Main method end");
    }
}
