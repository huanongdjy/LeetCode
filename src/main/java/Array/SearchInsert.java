package Array;

/**
 * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        if(nums[right] < target){
            return nums.length;
        }
        int len = nums.length;
        while (left < right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2,  4, 5};
        SearchInsert ser = new SearchInsert();
        System.out.println(ser.searchInsert(nums, 1));
    }
}
