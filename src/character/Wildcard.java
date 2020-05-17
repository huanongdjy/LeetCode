package character;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 */
public class Wildcard {
    public boolean isMatch(String s, String p) {
        boolean flag = false;
        if(s == p)return true;
        if(s==null||p==null)return false;
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();
        int sl = s.length();
        int pl = p.length();
        int i=0, j=0;

        while(i<sl&&pl>j){
            if(charp[j]=='?'){
                j++;
                i++;
                continue;
            }
            if(flag&&chars[i]==charp[j]){
                i++;
                j++;
                flag = false;
            }else if(flag&&chars[i]!=charp[j]){
                i++;
            }
            if(j<pl&&'*'==charp[j]){
                flag = true;
                j++;
            }else if(!flag){
                if(charp[j]!=chars[i])return false;
                i++;
                j++;
            }

        }
        return pl==j;
    }

    public static void main(String[] args) {
        Wildcard wi = new Wildcard();
//        System.out.print(wi.isMatch("adceb", "*a*eb"));;
        System.out.print(wi.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));;
    }

}
