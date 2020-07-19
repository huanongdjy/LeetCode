package character;

import java.util.Arrays;
import java.util.LinkedList;

public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        /* remove the remaining digits from the tail. */
        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }

//    private String trim0(String str){
//        int len1 = str.length();
//        int i=0;
//        for( ;i<len1; i++){
//            if(str.charAt(i)!='0')
//                break;
//        }
//        len = len - i;
//        return str.substring(i).equals("")?"0":str.substring(i);
//    }

    public static void main(String[] args) {
        RemoveKdigits rk = new RemoveKdigits();
        System.out.println(rk.removeKdigits("143231219", 5));
        System.out.println(rk.removeKdigits("1143", 2));
        System.out.println(rk.removeKdigits("10200", 1));
        System.out.println(rk.removeKdigits("10", 1));;
        System.out.println(rk.removeKdigits("9", 1));
        System.out.println(rk.removeKdigits("100", 1));
        System.out.println(rk.removeKdigits("1234567890", 9));
    }
}
