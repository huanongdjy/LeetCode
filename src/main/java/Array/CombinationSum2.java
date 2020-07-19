package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个数组?candidates?和一个目标数?target?，找出?candidates?中所有可以使数字和为?target?的组合。
 *
 * candidates?中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum2 {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private int[] candidates;
    private int len;

    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue == 0) {
            // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
            res.add(new ArrayList<>(pre));
            return;
        }
        // 优化添加的代码2：在循环的时候做判断，尽量避免系统栈的深度
        // residue - candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
        // 这一点基于原始数组是排序数组的前提，因为如果计算后面的剩余，只会越来越小
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
            findCombinationSum(residue - candidates[i], i+1, pre);
            pre.pop();
            while( i +1 < len&&candidates[i]==candidates[i+1])
                i+=1;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
//        int[] candidates = {2,5,2,1,2};
        int target = 8;
        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> combinationSum = solution.combinationSum2(candidates, target);
        System.out.println(combinationSum);
    }
}
