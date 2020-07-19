package character;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 */
public class Wildcard {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)||"*".equals(p))return true;
        if(s.isEmpty()||p.isEmpty())return false;
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();
        int sl = s.length();
        int pl = p.length();
        int i=0, j=0;
        int tms = -1, tmp = -1;
        while(i<sl){
            if(j<pl&&(charp[j]=='?'||charp[j]==chars[i])){
                j++;
                i++;
            }else if(j<pl&&charp[j]=='*'){
                j++;
                tmp = j;
                tms = i;
            }else if(tms>-1){
                i = ++tms;
                j = tmp;
            }else return false;
        }
        while (j < pl && charp[j] == '*') ++j;
        return pl==j;
    }

    public static void main(String[] args) {
        Wildcard wi = new Wildcard();
//        System.out.print(wi.isMatch("adceb", "*a*cb"));;
        System.out.print(wi.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));;
//        System.out.print(wi.isMatch("cb", "?a"));;
//        System.out.print(wi.isMatch("aaa", "*a"));;
    }

}
