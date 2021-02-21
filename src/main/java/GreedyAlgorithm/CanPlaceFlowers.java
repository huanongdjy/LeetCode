package GreedyAlgorithm;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;

        /*if (flowerbed == null || flowerbed.length == 0) return n == 0;

        int countOfZero = 1; // 当前全0区段中连续0的数量，刚开始预设1个0，因为开头花坛的最左边没有花，可以认为存在一个虚无的0
        int canPlace = 0; // 可以种的花的数量
        for (int bed : flowerbed) {
            if (bed == 0) { // 遇到0，连续0的数量+1
                countOfZero++;
            } else { // 遇到1，结算上一段连续的0区间，看能种下几盆花：(countOfZero-1)/2
                canPlace += (countOfZero-1)/2;
                if (canPlace >= n) return true;
                countOfZero = 0; // 0的数量清零，开始统计下一个全0分区
            }
        }
        // 最后一段0区还未结算：
        countOfZero++; // 最后再预设1个0，因为最后花坛的最右边没有花，可以认为存在一个虚无的0
        canPlace += (countOfZero-1)/2;

        return canPlace >= n;*/
    }

    public static void main(String[] args) {
        CanPlaceFlowers cpf =new CanPlaceFlowers();
        int[] nums = {0,0,1,0,1};
        boolean ret = cpf.canPlaceFlowers(nums, 1);
        System.out.println(ret);

    }
}
