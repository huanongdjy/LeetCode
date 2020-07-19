package Array;

/**
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class AddBinary
{
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();

    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
//        String a = "101";
//        String b = "101";
//        String a = "0";
//        String b = "0";
        String a = "11";
        String b = "1";
        String c = ab.addBinary(a,b );
        System.out.println(c);
    }
}
