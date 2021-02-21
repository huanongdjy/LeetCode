package character;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */
public class Convert {
    public String convert(String s, int numRows) {
        /*if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();

        作者：LeetCode
        链接：https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
        if(numRows==1) return s;
        StringBuilder ret= new StringBuilder();
        char[] str2char = s.toCharArray();
        int i=0,num=0;
        boolean has = true;
        while(ret.length()!=s.length()){
            ret.append(str2char[i]);

            if(!has){
                if(num==0||num+1==numRows)
                    i += (numRows-1) * 2 ;
                else
                    i += (numRows-1) * 2  - (numRows-num-1) * 2;
                has = true;
            }else{
                if(num+1!=numRows){
                    i += (numRows-num-1) * 2 ;
                }else{
                    i += numRows * 2 -2 ;
                }
                has = false;
            }
            if(i>=s.length()){
                i = ++num;
                has = true;
            }
        }
        return ret.toString();
    }
}
