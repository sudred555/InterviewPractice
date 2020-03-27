/**
 *
 */
package com.heaps;

import java.util.PriorityQueue;

/**
 * @author sudhe
 */
public class MedianFinder {

    // Root will be minimum than all its children
    PriorityQueue<Integer> minHeap;
    // Root will be maximun than all its children
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        // Always add element first ti min heap
        minHeap.offer(num);
        // pops out the lowest number from min head and adds to max heap
        maxHeap.offer(minHeap.poll());
        // balancing the sizes of both heaps, this is used to find median
        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }

    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
