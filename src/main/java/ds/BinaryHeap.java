package ds;

public class BinaryHeap {
    final int[] heap;
    final int capacity;
    int size = 0;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
    }

    public void insert(int num) {
        heap[size] = num;
        heapifyUp(size++);
    }

    private int parentIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    private void heapifyUp(int index) {
        int parentIndex = parentIndex(index);
        if (heap[parentIndex] < heap[index]) {
            swap(parentIndex, index);
            heapifyUp(parentIndex);
        }
    }

    private void swap(int parentIndex, int index) {
        int temp = heap[parentIndex];
        heap[parentIndex] = heap[index];
        heap[index] = temp;
    }

    public int extractMax() {
        return heap[0];
    }

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(10);
        binaryHeap.insert(10);
        binaryHeap.insert(32);
        binaryHeap.insert(53);
        binaryHeap.insert(23);
        binaryHeap.insert(34);

        System.out.println(binaryHeap.extractMax());
    }
}
