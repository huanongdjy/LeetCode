package Array;

import java.util.PriorityQueue;


/**
 * 时间复杂度 : {O}(N \log k)O(Nlogk)。
 * 空间复杂度 : {O}(k)O(k)，用于存储堆元素。
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2); // 大顶堆、小顶堆

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }
}
