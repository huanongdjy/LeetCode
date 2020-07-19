package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * ����һ�����ظ�Ԫ�ص�����?candidates?��һ��Ŀ����?target?���ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�
 *
 * candidates?�е����ֿ����������ظ���ѡȡ��
 *
 * ˵����
 *
 * �������֣�����?target��������������
 * �⼯���ܰ����ظ�����ϡ�?
 *
 * ʾ�� 1:
 *
 * ����: candidates = [2,3,6,7], target = 7,
 * ����⼯Ϊ:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 */
public class CombinationSum {
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
            findCombinationSum(residue - candidates[i], i, pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // �Ż���ӵĴ���1���ȶ��������򣬿�����ǰ��ֹ�ж�
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<Integer>());
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
        System.out.println(combinationSum);
    }
}
