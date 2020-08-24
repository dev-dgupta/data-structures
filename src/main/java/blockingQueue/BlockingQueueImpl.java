package blockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Divya.Gupta on 09-04-2018.
 */
public class BlockingQueueImpl {

    private final Lock lock;
    private final Condition bufferNotFull;
    private final Condition bufferNotEmpty;
    //    private final static int capacity = 10;
    private final Queue queue = new LinkedList();

    private int limit;

    public BlockingQueueImpl(int limit) {
        this.limit = limit;
        this.lock = new ReentrantLock();
        this.bufferNotFull = lock.newCondition();
        this.bufferNotEmpty = lock.newCondition();
    }

    public void enqueue(int number) {
        lock.lock();
        try {
            while (queue.size() == limit) {
                System.out.println(Thread.currentThread().getName() + " : Buffer is full, waiting");
                bufferNotEmpty.await();
            }

            boolean isAdded = queue.offer(number);
            if (isAdded) {
                System.out.printf("%s added %d into queue %n", Thread.currentThread().getName(), number);
                // signal consumer thread that, buffer has element now
                System.out.println(Thread.currentThread().getName() + " : Signalling that buffer is no more empty now");
                bufferNotFull.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public Object dequeue() {
        lock.lock();
        Object element = null;
        try {
            while (queue.size() == 0) {
                System.out.println(Thread.currentThread().getName() + " : Buffer is empty, waiting");
                bufferNotFull.await();
            }
            element = queue.remove();
            if (element != null) {
                System.out.printf("%s consumed %d from queue %n", Thread.currentThread().getName(), element);
                // signal producer thread that, buffer may be empty now
                System.out.println(Thread.currentThread().getName() + " : Signalling that buffer may be empty now");
                bufferNotEmpty.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
        return element;
    }

}
