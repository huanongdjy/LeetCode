package Array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums){
        int l = nums.length;
        if(l < 2) return 1;
        int index = 1;
        for(int i = 1; i < l; i++){
            if(nums[i] != nums[i-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        /*for (int i = 0; i < l; i++) {
            System.out.println(nums[i]);
        }*/
       return index;
    }
    public static void main(String[] args) {
        RemoveDuplicates re  = new RemoveDuplicates( );
        int[] a = new int[]{0,1,2, 2,2,2 , 2, 2,3,3,4};
//        a[0] = 1;
//        a[1] = 1;
//        a[2] = 2;
        System.out.println(re.removeDuplicates(a));

    }
}
