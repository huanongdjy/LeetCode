package Array;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int len = nums.length;
        int left = 0;
        int right = len -1;
        boolean leftFlag = false, rightFlag = false;
        while(left <= right){
            if(leftFlag&&rightFlag){
                break;
            }
            if(!leftFlag){
                if(nums[left] == target){
                    res[0] = left;
                    leftFlag = true;
                }else {
                    left++;
                }
            }
            if(!rightFlag){
                if(nums[right] == target&&!rightFlag){
                    res[1] = right;
                    rightFlag = true;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int[] nums = {5,7,7,7,8,8};
//        int[] nums = {1,2,3};
        System.out.println(sr.searchRange(nums, 7));
    }
}
