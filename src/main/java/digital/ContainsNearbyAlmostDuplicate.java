package digital;

public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null)return false;
        int len = nums.length;
        for(int i=0; i<len; i=i+1){
            for(int j=i+1; j<len&&j<=i+k; j++){
                if(Math.abs((long)nums[i]-nums[j])<=t&&Math.abs(i-j)<=k)return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648,2147483647};
        ContainsNearbyAlmostDuplicate containsNearbyAlmostDuplicate = new ContainsNearbyAlmostDuplicate();
        boolean b = containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(nums, 1,1);
        System.out.println(b);
    }
}
