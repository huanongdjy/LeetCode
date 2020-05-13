package character;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2)) return "0";
        StringBuilder result = new StringBuilder();
        char[] numCh1 = num1.toCharArray();
        char[] numCh2 = num2.toCharArray();
        int len1 = numCh1.length, len2 = numCh2.length;
        int[] ret = new int[len1 + len2];
        for(int i = len1 - 1; i >= 0 ; i--) {
            int n1 = numCh1[i] - '0';
            for(int j=len2 - 1; j >= 0; j--) {
                int n2 = numCh2[j] - '0';
                int temp = n1 * n2;
                    ret[i + j + 1] += temp;
                    int  left=1;
                    while (i+j+left>=0&&ret[i+j+left]>=10){
                        int a = ret[i+j+left];
                        ret[i+j+left] = a%10 ;
                        left--;
                        ret[i+j+left] = ret[i+j+left] + a/10;
                    }
            }
        }
        for(int i = 0; i < ret.length; i++){
            if (i==0&&ret[i] == 0) continue;
                result.append(ret[i] );
        }
        return result.toString();
    }


    public static void main(String[] args) {
        Multiply ml = new Multiply();
        System.out.println(ml.multiply("456", "123"));
    }
}
