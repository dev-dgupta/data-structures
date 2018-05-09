package heapImpl;

/**
 * Created by Divya.Gupta on 24-04-2018.
 */


// stored as an array--
// 1. used to find out the kth smallest element in an array
// 2. used to keep the order of list intact and add sum of elements to get it bigger than k
public class MinHeapImpl {

    int capacity = 10;
    int size = 0;
    int[] minHeap = new int[capacity];


    private int getLeftIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRigntIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftIndex(parentIndex) <= size;
    }

    private boolean hasRightIndex(int parentIndex) {
        return getRigntIndex(parentIndex) <= size;
    }

    private boolean hasChildIndex(int childIndex) {
        return getParentIndex(childIndex) > size;
    }


}

