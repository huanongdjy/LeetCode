package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ m x n ��Ԫ�صľ���m ��, n �У����밴��˳ʱ������˳�򣬷��ؾ����е�����Ԫ�ء�
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;

        //ͳ�ƾ���������ڵĲ������������ǿգ���ô���Ĳ�������Ϊ1��
        int count = (Math.min(m, n)+1)/2;
        //���ⲿ���ڲ�����������ӡ����
        while(i < count) {
            for (int j = i; j < n-i; j++) {
                list.add(matrix[i][j]);
            }
            for (int j = i+1; j < m-i; j++) {
                list.add(matrix[j][(n-1)-i]);
            }

            for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
                list.add(matrix[(m-1)-i][j]);
            }
            for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
                list.add(matrix[j][i]);
            }
            i++;
        }
        return list;

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
        int[][] nums = new int[][]{
                {1,2,3},
                {4,5,6},
                {4,5,6},
                {4,5,6}
        };
//        int[][] nums = new int[][]{
//                {7},
//                {6},
//                {9},
//                {9},
//                {9},
//                {9},
//                {9},
//                {9}
//        };
        so.spiralOrder(nums);
    }
}
