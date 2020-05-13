package Array;

import java.util.*;

/**
 * ����һ������ļ��ϣ���ϲ������ص������䡣
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0)
            return res.toArray(new int[0][]);

        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);// a[0] - b[0]����0�ͽ���˳��
        // ���ݶ�ά�����һ�����ִ�С��ÿһ����������
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // i���ܵ����һ��,����ҪС��(����ĳ��� - 1)
            // �ж������е�right����һ�е�left��С,��right���½��и����ֵ,֮���ٲ��Ͻ���whileѭ���ж�
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[] { left, right });
            i++;
        }

        return res.toArray(new int[0][]);
    }

}
