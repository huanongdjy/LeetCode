package digital;

/**
 *
 * 字符串转换整数 (atoi)
 *
 *
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查第一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyAtoi {
    public static int myAtoi(String str) {
        str = str.trim();
        if(str==""||str.length()==0)return 0;
        int a=0,b=0;
        int sta = 0;
        boolean h = true;
        long l=0;
        char[] c = str.toCharArray();
        for(int i=0; i<c.length; i++){
            if(h==true&&c[i]!='-'&&c[i]!='+'&&!(c[i]<=57&&c[i]>=48)&&c[i]!=' ')return 0;
            if(h==true&&(c[i]=='-'||c[i]=='+'||(c[i]<=57&&c[i]>=48))){
                a = i;
                h = false;
            } else if(c[i]<=57&&c[i]>=48){
                b=i;
            }else if(h==false){
                b=i-1;
                break;
            }
        }
        if(c[a]=='+'||c[a]=='-')sta = a+1;
        else sta = a;
        for(int i=sta; i<=b; i++){
            l = l*10;
            l = l + c[i]-48;
            if(c[a]=='-'&&-l<Integer.MIN_VALUE){
                l=Integer.MIN_VALUE;
                break;
            }
            if(c[a]!='-'&&l>Integer.MAX_VALUE){
                l=Integer.MAX_VALUE;
                break;
            }

        }
        if(c[a]=='-')
            l = -l;
        return (int)l;
    }
}
