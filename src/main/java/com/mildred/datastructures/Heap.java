package com.mildred.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * The Heap class represents a max heap, a complete binary tree in which the value in each internal node
 * is greater than or equal to the values in the children of that node.
 */
public class Heap {
    private List<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    /**
     * This method returns a new list containing all elements of the heap
     * @return
     */
    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    /**
     * This method returns the index of the left child of a node at a given index
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * This method returns the index of the right child of a node at a given index,
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * This method returns the index of the parent of a node at a given index,
     * @param index
     * @return
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * This method swaps the elements at two given indices in the heap.
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    /**
     * This method inserts a value into the heap while maintaining the max heap property
     * @param value
     */
    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while(current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /**
     * This method removes the root element from the heap and maintains the heap property.
     * @return
     */
    public Integer remove() {
        if(heap.size() == 0) return null;

        if(heap.size() == 1) return heap.remove(0);

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);
        return maxValue;
    }

    /**
     * This method takes an integer index as a parameter and restore the max heap property when it is violated
     * by the node at the input index.
     * @param index
     */
    private void sinkDown(int index) {
        int maxIndex = index;
        while(true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if(leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) maxIndex = leftIndex;

            if(rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) maxIndex = rightIndex;

            if(maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }

}
