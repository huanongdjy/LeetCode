package Array;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        CanJump cj = new CanJump();
//        int[] nums = new int[]{2,0,0,1};
//        int[] nums = new int[]{13,2,3};
        int[] nums = new int[]{3,0,8,2,0,0,1};
        System.out.println(cj.canJump(nums));
    }
}
