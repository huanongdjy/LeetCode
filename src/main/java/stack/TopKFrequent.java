package stack;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素
 *
 * n1 - n2 为最小堆顶
 * n2 - n1 为最大堆顶
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }
}
