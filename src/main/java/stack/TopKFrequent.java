package stack;

import java.util.*;

/**
 * ����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ��
 *
 * n1 - n2 Ϊ��С�Ѷ�
 * n2 - n1 Ϊ���Ѷ�
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
