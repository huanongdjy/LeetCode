package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * ����һ������?candidates?��һ��Ŀ����?target?���ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�
 *
 * candidates?�е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
 *
 * ˵����
 *
 * �������֣�����Ŀ������������������
 * �⼯���ܰ����ظ�����ϡ�?
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/combination-sum-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CombinationSum2 {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private int[] candidates;
    private int len;

    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue == 0) {
            // Java �пɱ���������ô��ݣ������Ҫ����ǰ path ���ֵ��������
            res.add(new ArrayList<>(pre));
            return;
        }
        // �Ż���ӵĴ���2����ѭ����ʱ�����жϣ���������ϵͳջ�����
        // residue - candidates[i] ��ʾ��һ�ֵ�ʣ�࣬�����һ�ֵ�ʣ�඼С�� 0 ����û�б�Ҫ���к����ѭ����
        // ��һ�����ԭʼ���������������ǰ�ᣬ��Ϊ�����������ʣ�ֻ࣬��Խ��ԽС
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            // ���ؼ�����ΪԪ�ؿ����ظ�ʹ�ã�����ݹ鴫����ȥ���� i ������ i + 1
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
        // �Ż���ӵĴ���1���ȶ��������򣬿�����ǰ��ֹ�ж�
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
