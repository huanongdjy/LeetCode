package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ m x n ��Ԫ�صľ���m ��, n �У����밴��˳ʱ������˳�򣬷��ؾ����е�����Ԫ�ء�
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length<=0)return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        int ver_len = matrix.length;
        int her_len = matrix[0].length;
        for(int i=0; i < (ver_len+1)/2; i++){

            for(int j=i; j < her_len-i; j++){
                ret.add(matrix[i][j]);
            }
            for(int j=i + 1;j<ver_len-i;j++){
                ret.add(matrix[j][her_len - 1 - i]);
            }
            for(int j=her_len-i -2;j >= i&&i<ver_len-1  - i;j--){
                ret.add(matrix[ver_len-1  - i][j]);
            }
            for(int j=ver_len -2 -i;j > i&&i<her_len - 1 -i;j--){
                ret.add(matrix[j][i]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        SpiralOrder so = new SpiralOrder();
//        int[][] nums = new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {9, 10, 11, 12}
//        };
//        int[][] nums = new int[][]{
//                {1,2,3}
//        };
//        int[][] nums = new int[][]{
//                {1,2,3},
//                {4,5,6},
//                {4,5,6},
//                {4,5,6}
//        };
        int[][] nums = new int[][]{
                {7},
                {6},
                {9},
                {9},
                {9},
                {9},
                {9},
                {9}
        };
        so.spiralOrder(nums);
    }
}
