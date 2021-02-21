package Array;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int left = 0, right = len-1;
        while(left <= right){
            int mid = left + (right - left) / 2;


            if(nums[mid] == target)
                return true;
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if(nums[mid] > nums[left]){

                if(nums[left] <= target && target < nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
            else{
                if(nums[mid] < target && target <= nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {1,1,3,1};
//        int[] nums = {2,1};
//        int[] nums = {7,8,1,2,3,4,5,6};
//        int[] nums = {3,4,5,6,7,8,1,2};
//        int[] nums = {1,3};
        int[] nums = {3,3,1};

        Search a = new Search();
        boolean b = a.search(nums,1);
        System.out.println(b);
    }
}
