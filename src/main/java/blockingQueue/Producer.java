package blockingQueue;

import java.util.Random;

/**
 * Created by Divya.Gupta on 10-04-2018.
 */
public class Producer extends Thread {
    BlockingQueueImpl blockingQueue;

    public Producer(BlockingQueueImpl sharedObj) {
        super("Producer");
        this.blockingQueue = sharedObj;
    }

    public void run() {
        int number = (new Random()).nextInt();
        blockingQueue.enqueue(number);
    }
}
