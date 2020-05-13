package Array;

import java.util.*;

/**
 * ����һ�����ظ����ֵ����У����������п��ܵ�ȫ���С�
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // �޸� 1������������߽��򶼿��ԣ���Ϊ�˼�֦����
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        // ʹ�� Deque �� Java �ٷ� Stack ��Ľ���
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        // ��� pre ֵ����������������û�г��ֵģ�����±߽� - 1 �������ϱ߽� + 1������
        // ����������� int ���͵����ֵ������Сֵ�����ܻ�������⣬����������û�м�������
        int pre = nums[0] - 1;
        for (int i = 0; i < len; ++i) {
            if (!used[i] && pre != nums[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, used, path, res);

                used[i] = false;
                path.removeLast();

                pre = nums[i];
            }
        }
    }


    public static void main(String[] args) {
        PermuteUnique pr = new PermuteUnique();
//        int a[] = new int[]{1,1,2,2};
        int a[] = new int[]{1,0,0,9,0};
        pr.permuteUnique(a);

    }
}
