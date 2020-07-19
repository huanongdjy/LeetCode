package character;

/**
 * �����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�
 *
 * �������Ϊ s �� t �н�����Ӣ��Сд��ĸ���ַ��� t ���ܻ�ܳ������� ~= 500,000������ s �Ǹ����ַ��������� <=100����
 *
 * �ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ����������磬"ace"��"abcde"��һ�������У���"aec"���ǣ���
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/is-subsequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * ����ⷨ���ж��ַ����Ƿ��������˳��
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] ts = s.toCharArray();
        char[] tt = t.toCharArray();
        int slen = s.length();
        int tlen = t.length();
        int j = 0;
        for(int i=0; i<tlen&&j<slen; i++){
            if(ts[j]==tt[i]){
                j++;
            }
        }
        if(j==slen){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence isb = new IsSubsequence();
        String t = "abcdef";
        String s = "acf";
        System.out.println(isb.isSubsequence(s, t));
    }
}
