package tree.heap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxHeap {
    private final int[] heap;
    private int size;
    private final int maxSize;

    public MaxHeap(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        this.heap = new int[maxSize];
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos + 1;
    }

    private int rightChild(int pos) {
        return 2 * pos + 2;
    }

    private boolean isLeaf(int pos) {
        return pos > (this.size / 2) && pos <= this.size;
    }

    private void swap(int fpos, int spos) {
        int temp = this.heap[fpos];
        this.heap[fpos] = this.heap[spos];
        this.heap[spos] = temp;
    }

    private void heapifyUp(int pos) {
        System.out.println("Heapify called for index: " + pos);
        System.out.println("its parent index: " + parent(pos));
        while (this.heap[pos] > this.heap[parent(pos)]) {
            swap(pos, parent(pos));
            pos = parent(pos);
        }
    }

    private void heapifyDown() {
        int pos = 0;
        while (!isLeaf(pos) && pos < this.size && leftChild(pos) < this.size && rightChild(pos) < this.size &&
                (this.heap[pos] < this.heap[leftChild(pos)] || this.heap[pos] < this.heap[rightChild(pos)])) {
            System.out.println("Inside while loop: " + pos);
            System.out.println("Current heap: " + Arrays.toString(this.heap));
            if (this.heap[rightChild((pos))] < this.heap[leftChild(pos)]) {
                swap(pos, leftChild(pos));
                pos = leftChild(pos);
            } else {
                swap(pos, rightChild(pos));
                pos = rightChild(pos);
            }
        }
    }

    private void insert(int element) {
        if (this.maxSize != this.size) {
            this.heap[this.size] = element;
            System.out.println("Before: " + Arrays.toString(this.heap));
            heapifyUp(this.size);
            this.size++;
            System.out.println(Arrays.toString(this.heap));
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("Heap is full");
        }
    }

    private int extractMax() {
        int poppedElement = heap[0];
        System.out.println("Current size is: " + this.size);
        swap(0, --size);
        heapifyDown();
        return poppedElement;
    }

    private void print() {
        System.out.println(Arrays.toString(this.heap));
    }

    public static void main(String[] args) {
        int maxSize = 10;
        MaxHeap heap1 = new MaxHeap(maxSize);
        heap1.insert(5);
        heap1.insert(10);
        heap1.insert(11);
        heap1.insert(20);
        heap1.insert(30);
        heap1.insert(12);
        heap1.insert(13);
        heap1.insert(45);
        heap1.insert(34);
        heap1.insert(90);
        heap1.print();
        for (int i = 0; i < maxSize; i++) {
            System.out.println("Element extracted: " + heap1.extractMax());
            heap1.print();
            System.out.println("--------------------------------------------------");
        }
        heap1.print();
    }
}
