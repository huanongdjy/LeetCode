package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *  factorials 剩余多少空格的情况下，的可能情况
 */
public class GetPermutation {
    public String getPermutation(int n, int k) {
        int[] factorials = new int[n];//可能性数组
        List<Integer> nums = new ArrayList() {{add(1);}};

        factorials[0] = 1;
        for(int i = 1; i < n; ++i) {
            // 当 当前位置是确定的时候，有几种可能性
            factorials[i] = factorials[i - 1] * i;
            nums.add(i + 1);
        }
        // 从0开始算，减 1，与可能性数组相对应
        --k;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > -1; --i) {
            int idx = k / factorials[i];// 第一位确定后，其余的最大可能性，商就可以做为起始数
            k -= idx * factorials[i]; // 固定一位后，算出是可能性中的第几个

            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GetPermutation gp = new GetPermutation();
        System.out.println(gp.getPermutation(3,5));
    }
}
