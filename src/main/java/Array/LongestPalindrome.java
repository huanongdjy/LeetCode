package Array;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = -1;
        int begin=0;
        for(int i=0; i<len; i++){
                dp[i][i] = true;
        }
        for(int j=1; j<len; j++){
            for(int i=0; i<j; i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }
                if(dp[i][j]&&maxLen<j-i+1){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }
    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("abc"));
    }
}
