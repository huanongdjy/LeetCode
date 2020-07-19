package Array;

public class RotateSearch {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
            else{
                if(nums[left] <= target && target < nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotateSearch ro = new RotateSearch();
        int[] nums = {4,5,6,0,1,2, 3};
//        int[] nums = {5,1,3};
        System.out.println(ro.search(nums, 1));
    }
}
