package dynamicPlanning;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *
 * 火车票有三种不同的销售方式：
 *
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 *
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MincostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int max = days[len - 1];
        int min = days[0];
        int[] dp = new int[max+31];
        for(int curr = max, i=len-1; curr>=min; curr--){
            if(curr==days[i]){
                dp[curr] = Math.min(costs[0]+dp[curr+1], costs[1]+dp[curr+7]);
                dp[curr] = Math.min(dp[curr], costs[2]+dp[curr+30]);
                i--;
            }else {
                dp[curr] = dp[curr+1];
            }
        }
        return dp[min];
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
        MincostTickets mincostTickets = new MincostTickets();
        int ret = mincostTickets.mincostTickets(days, costs);
        System.out.println(ret);
    }
}
