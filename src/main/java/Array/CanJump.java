package Array;

/**
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * �ж����Ƿ��ܹ��������һ��λ�á�
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        CanJump cj = new CanJump();
//        int[] nums = new int[]{2,0,0,1};
//        int[] nums = new int[]{13,2,3};
        int[] nums = new int[]{3,0,8,2,0,0,1};
        System.out.println(cj.canJump(nums));
    }
}
