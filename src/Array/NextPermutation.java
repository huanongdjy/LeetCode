package Array;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int tag = -1;
        for (int i=nums.length -1; i>=1; i--){
            for (int j=i -1; j>=0; j--){
                if(nums[i]>nums[j]){
                   if(j > index) {
                       index = j;
                       tag = i;
                   }
                }
            }
        }
        if(index != -1){
            int temp = nums[index];
            nums[index] = nums[tag];
            nums[tag] = temp;
            for(int x = index + 1; x<nums.length; x++){
                for(int y = x+1; y<nums.length; y++){
                    if(nums[x]>nums[y]){
                        int temp1 = nums[x];
                        nums[x] = nums[y];
                        nums[y] = temp1;
                    }
                }
            }
            return;
        }
        Arrays.sort(nums);
        return;
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = {1,3,2};
        n.nextPermutation(nums);
        // 1£¬3£¬2     2£¬1£¬3
        //[4,2,0,2,3,2,0]
    }
}
