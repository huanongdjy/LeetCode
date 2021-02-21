package GreedyAlgorithm;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitII {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)return 0;
        int result = 0;
        int tempMax = 0;
        int len = prices.length;
        int buy = prices[0];
        for(int i=0; i<len; i++){
            if(prices[i]<buy){
                buy = prices[i];
                result +=tempMax;
                tempMax = 0;
                continue;
            }else if(i!=0&&prices[i]<prices[i-1]){
                buy = prices[i];
                result += tempMax;
                tempMax = 0;
                continue;
            }
            tempMax = Math.max(prices[i]-buy, tempMax);
        }
        return result+=tempMax;
    }

    public static void main(String[] args) {
        MaxProfitII maxProfitII = new MaxProfitII();
//        int[] a = new int[]{7,1,5,3,6,4};
        int[] a = new int[]{1,2,3,4,5};
        int ret = maxProfitII.maxProfit(a);
        System.out.println(ret);
    }
}
