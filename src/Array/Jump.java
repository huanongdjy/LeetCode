package Array;

import java.util.List;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
