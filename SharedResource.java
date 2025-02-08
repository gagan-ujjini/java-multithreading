public class SharedResource {
    boolean itemAvaialble = false;

    // synchronized put the monitor lock
    public synchronized void addItem() {
        itemAvaialble = true;
        System.out.println("Item added by: " + Thread.currentThread().getName() + " and invoking all threads");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("ConsumeItem method invoked by: " + Thread.currentThread().getName());

        // using while loop to avoid "spurious wakeup", sometimes because of system
        // noise
        while (!itemAvaialble) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now");
                wait(); // it releases all the monitor lock
            } catch (InterruptedException e) {
                // handle exception here
            }
        }

        System.out.println("Item consumed by: " + Thread.currentThread().getName());
        itemAvaialble = false;
    }
}
