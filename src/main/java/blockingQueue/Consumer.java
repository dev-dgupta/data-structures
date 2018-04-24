package blockingQueue;

/**
 * Created by Divya.Gupta on 10-04-2018.
 */
public class Consumer extends Thread {
    BlockingQueueImpl blockingQueue;

    public Consumer(BlockingQueueImpl sharedObj) {
        super("Consumer");
        this.blockingQueue = sharedObj;
    }


    public void run() {
        blockingQueue.dequeue();
    }

}
