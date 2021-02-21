package GreedyAlgorithm;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int maxRet = 0;
        int len = prices.length;
        int buy = prices[0];
        for(int i=1; i< len; i++){
            if(prices[i]<buy){
                buy = prices[i];
                continue;
            }
            maxRet = Math.max((prices[i] - buy), maxRet);
        }
        return maxRet;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,5,3,6,4, 1, 9};
        MaxProfit mp = new MaxProfit();
        int ret = mp.maxProfit(nums);
        System.out.println(ret);
    }
}
