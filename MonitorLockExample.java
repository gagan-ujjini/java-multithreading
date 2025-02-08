public class MonitorLockExample {
    /*
     * Monitor Lock: Helps to make sure that only one thread goes inside a
     * particular section of code (a synchronized block or method)
     */

    public synchronized void task1() {
        // do something
        try {
            System.out.println("Inside task1");
            Thread.sleep(10000); // sleep for 10 seconds
        } catch (InterruptedException e) {
            // handle exeception here
            e.printStackTrace();
        }
    }

    public synchronized void task2() {
        System.out.println("task2, but before synchronized block");
        synchronized (this) {
            System.out.println("task2, inside synchronized block");
        }
    }

    public void task3() {
        System.out.println("task3");
    }
}
