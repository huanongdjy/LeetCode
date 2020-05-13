package digital;

/**
 * 编写一个高效的算法来判断 m, n 矩阵中，是否存在一个目标值 x 。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0||matrix[0].length==0) return false;
        if(matrix==null)return false;
        if(matrix[0][0] == target) return true;
        int top=0, bot = matrix.length-1;
        int left = 0, right = matrix[0].length-1;
        int len = matrix[0].length -1 ;
        while(top < bot){
            int hmid = (bot - top) / 2 + top;
            if(matrix[hmid][0] == target) return true;
            if(matrix[hmid][0] > target){
                bot = hmid - 1;
            }else {
                if(matrix[hmid][len] >= target){
                    top = hmid;
                    break;
                }
                top = hmid + 1;
            }
        }
        while (left <= right){
            int rmid = (right - left) / 2 + left;
            if(matrix[top][rmid] == target) return true;
            if(matrix[top][rmid] > target){
                right = rmid - 1;
            }else {
                left = rmid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix sr = new SearchMatrix();
        int[][] a = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(sr.searchMatrix(a, 20));
    }
}
