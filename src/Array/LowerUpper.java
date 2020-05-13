package Array;

import java.util.ArrayList;
import java.util.List;

public class LowerUpper {
    public List<String> lowerUper(int[] nums, int lower, int upper){
        List<String> res = new ArrayList<>();
        if(upper == Integer.MIN_VALUE)return res;
        if(nums.length == 0) {
            int pre = lower;
            int lat = upper;
            if(pre >= (Integer.MIN_VALUE==lat?lat:lat -1)){
                res.add("" + pre);
            }else {
                res.add(pre + "->" + (lat) );
            }
            return res;
        }
        int len = nums.length;
        if(nums[0]>=(Integer.MAX_VALUE==lower?lower:lower+1)){
            int pre = lower;
            int lat = nums[0];
            if(pre == (Integer.MIN_VALUE==lat?lat:lat -1)){
                res.add("" + pre);
            }else {
                res.add(pre + "->" + (Integer.MIN_VALUE==lat?lat:lat -1) );
            }
        }
        for(int i = 0, j=1; j<len; i++, j++){
            if(nums[i]>=lower&&nums[j]<=upper){
                int pre = Integer.MAX_VALUE==nums[i]?nums[i]:nums[i] + 1;
                int lat = nums[j];
                if(pre < lat){
                    if(pre == (Integer.MIN_VALUE==lat?lat:lat -1)){
                        res.add("" + pre);
                    }else {
                        res.add(pre + "->" + (Integer.MIN_VALUE==lat?lat:lat -1) );
                    }
                }
            }
        }
        if(nums[len-1] <= upper-1){
            int pre = nums[len-1];
            int lat = upper;
            if(pre == (Integer.MIN_VALUE==lat?lat:lat -1)){
                res.add("" + upper);
            }else {
                res.add((pre + 1) + "->" + lat );
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LowerUpper lp = new LowerUpper();
//        int[] nums = {0, 1, 2, 3, 7};
//        int[] nums = {0, 1, 3, 50, 75};
//        int[] nums = {603824346,603977020,604092877,604105422,604174996,604184738,604195274,604210155,604235250,604290624,604298508,604341114,604363593,604393444,604395283,604399085,604427423,604458769,604479228,604508307,604520708,604589341};
//        int[] nums = {1,2,3,4,5,6,7,8};
//        int[] nums = {-2147483648};
        int[] nums = {-2147483648,-2147483648,0,2147483647,2147483647};
        lp.lowerUper(nums, -2147483648, 2147483647);
    }
}
