package GreedyAlgorithm;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 *
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 *
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TotalMoney {
    public int totalMoney(Integer n) {
        int sum = 0;
        int leave = n%7;
        int round = n/7;
        for(int i=0; i<round; i++){
            sum += 28 + i*7;
        }
        for(int i= 1; i<=leave; i++){
            sum += round + i;
        }
        return sum;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        TotalMoney tm = new TotalMoney();
        TotalMoney.class.newInstance();
        System.out.println(TotalMoney.class.getMethod("totalMoney", Integer.class).invoke(tm,5));
//        );
        System.out.println(tm.totalMoney(20));
        Map<String,String> map = new HashMap<>();
        map.put("123","123");
        int n = 6;
        n |= n>>>1;
        System.out.println(n);
        n |= n>>>2;
        System.out.println(n);
        n |= n>>>4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
    }
}
