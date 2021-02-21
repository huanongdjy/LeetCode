package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist {
    int len = 0;
    int ver, row;
    boolean userd[][];
    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        List<Character> list = new ArrayList<>();
        boolean result = false;
        len = word.length();
        ver = board.length;
        row = board[0].length;
        userd = new boolean[ver][row];
        for(int i=0; i<ver; i++){
            for(int j=0; j<row; j++){
                if(board[i][j]==word.charAt(0))
                    if(findExist(i,j,board, 0, word)){
                        return true;
                    }
            }
        }
        return result;
    }
    private boolean findExist(int i , int j, char[][] board, int curr, String word){
        if(curr==len-1){
            return board[i][j]==word.charAt(curr);
        }
        if(board[i][j]==word.charAt(curr)){
            userd[i][j]=true;
            for(int index=0; index<4; index++){
                int newX = i + direction[index][0];
                int newY = j + direction[index][1];
                if(newX>=0&&newX<ver&&newY>=0&&newY<row&&!userd[newX][newY]){
                     if(findExist(newX, newY, board, curr+1, word)){
                         return true;
                     }
                }
            }
            userd[i][j]=false;
        }
        return false;
    }
    public static void main(String[] args) {

        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        String word = "ABCCED";


//        char[][] board = {{'a', 'b'}};
//        String word = "ab";
        Exist solution = new Exist();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}
