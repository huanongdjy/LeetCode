package Array;

import java.util.List;

/**
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/jump-game-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Jump {
    public int jump(int[] nums) {
            int lastPos = nums.length - 1;
            int step = 0;
            boolean t = false;
            int index = lastPos;
            for (int i = nums.length - 2; i >= 0; ) {
                for(int j = lastPos - 1; j >=0; j--){
                    if(j + nums[j] >= lastPos && j < index){
                        index = j;
                        t = true;
                    }
                }
                if(t){
                    lastPos = index;
                    i = index - 1;
                    step++;
                    t = false;
                }else {
                    i--;
                }
            }
            if(lastPos==0)
                return step;
            return 0;
    }
    public static void main(String[] args) {
        Jump cj = new Jump();
//        int[] nums = new int[]{2,0,0,1};
//        int[] nums = new int[]{2,3,1,1,4};
                int[] nums = new int[]{13,2,3};
//        int[] nums = new int[]{3,0,8,2,0,0,1};
        System.out.println(cj.jump(nums));
    }

}
