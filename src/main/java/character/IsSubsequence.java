package character;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 另外解法：判断字符串是否包含，按顺序
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
