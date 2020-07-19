package Array;

import java.util.PriorityQueue;


/**
 * ʱ�临�Ӷ� : {O}(N \log k)O(Nlogk)��
 * �ռ临�Ӷ� : {O}(k)O(k)�����ڴ洢��Ԫ�ء�
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2); // �󶥶ѡ�С����

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
