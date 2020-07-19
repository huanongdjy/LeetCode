package Array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int l = nums.length;

        int index = 0;
        for(int i = 0; i < l; i++){
            if(nums[i]!=val){
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = 0; i < l; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
        return index;
    }
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] a = new int[]{1};
        System.out.println(re.removeElement(a, 1));
    }
}
