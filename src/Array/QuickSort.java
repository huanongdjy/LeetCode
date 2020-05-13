package Array;

/**
 * ʱ�临�Ӷ�O(nlogn)~O(n^2)
 * �ռ临�Ӷ�O(logn)~O(n)
 */
public class QuickSort {
    public int[] quickSort(int[] nums, int beg, int end){
        if(end > beg){
            int i = beg, j = end, temp = nums[i];
            while(i<j){
                while(i<j&&nums[j]> temp){
                    j--;
                }
                if(i < j)
                    nums[i++] = nums[j];

                while(i < j && nums[i] < temp) // ���������ҵ�һ�����ڵ���temp����
                    i++;
                if(i < j)
                    nums[j--] = nums[i];
            }
            nums[i] = temp  ;

            quickSort(nums, beg, j-1);
            quickSort(nums, j+1, end);
        }
        return nums;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] nums = {6,1,2,7,9,3,4,5,10,8};
        qs.quickSort(nums, 0, nums.length-1);
        System.out.println(nums);
    }
}
