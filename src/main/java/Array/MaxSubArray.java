package Array;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxRet = nums[0];
        int len = nums.length;
        for(int i=1; i< len; i++){
            if(nums[i] + nums[i-1] > nums[i]){
                nums[i] += nums[i-1];
            }
            maxRet = Math.max(nums[i], maxRet);
        }
        return maxRet;
    }
}
