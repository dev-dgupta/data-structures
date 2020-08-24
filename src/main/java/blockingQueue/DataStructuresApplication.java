package blockingQueue;

/**
 * Created by Divya.Gupta on 09-04-2018.
 */

public class DataStructuresApplication {

    public static void main(String[] args) {

        // Object on which producer and consumer thread will operate
        BlockingQueueImpl sharedObject = new BlockingQueueImpl(10);
        // creating producer and consumer threads
        Producer p = new Producer(sharedObject);
        Consumer c = new Consumer(sharedObject);
        // starting producer and consumer threads
        p.start();
        c.start();

    }
}
