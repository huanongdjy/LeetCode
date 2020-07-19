package character;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        if(s.isEmpty())return t.charAt(0);
        char res = 0;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int len = chars.length;
        int lens = s.length();
        System.out.print("len :" + len + ", lens :" + lens);
        for(int i=0; i<len; i++){
            res ^= (char) (chars[i] ^ chart[i]);
        }
        res = (char) (res ^ chart[len]);
        return res;
    }

    public static void main(String[] args) {
        FindTheDifference ftd = new FindTheDifference();
        String s = "abcd";
        String t = "abcde";
        System.out.print(ftd.findTheDifference(s, t));
    }
}
