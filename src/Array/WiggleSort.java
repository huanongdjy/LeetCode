package Array;

import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int mid = len/2;
        int[] left = new int[len%2==0?mid:mid + 1];
        int[] right = new int[mid];
        int i = 0;
        System.arraycopy(nums, 0, left, 0,
                len%2==0?mid :mid + 1);
        System.arraycopy(nums, len%2==0?mid :mid + 1  , right, 0,
                mid);
        int lenLeft = left.length;
        int lenRight = right.length;
        for (; i < len / 2; i++) {
            nums[2*i]=left[lenLeft - i -1];
            nums[2*i+1]=right[lenRight - i - 1];
        }
        if (len%2!=0) nums[len-1]=left[lenLeft - i -1];

    }

    public static void main(String[] args) {
        WiggleSort wi = new WiggleSort();
//        int[] nums = {1,5,1,1,6, 4};
//        int[] nums = {1,2,2,1,2,1,1,1,1,2,2,2};
//        int[] nums = {1,1,2,1,2,2,1};
        int[] nums = {5,8,3,7,2,6,1,5,5};
        wi.wiggleSort(nums);
        System.out.println(nums);
    }
}
