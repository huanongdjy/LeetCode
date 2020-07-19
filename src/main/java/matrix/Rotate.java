package matrix;

/**
 * ����һ�� n?��?n �Ķ�ά�����ʾһ��ͼ��
 * ��ͼ��˳ʱ����ת 90 �ȡ�
 * ˵����
 * �������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
 *
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i=0; i<=len/2; i++){
            for(int j=i;j<len-i-1;j++){
                int temp = matrix[i][j];
                matrix[i][j]= matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len -1 -i ][len - 1 - j];
                matrix[len -1 -i][len - 1 - j] = matrix[j ][len - 1 - i ];
                matrix[j][len - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Rotate ra = new Rotate();
//        int[][] nums = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9},
//        };
        int[][] nums = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };
        ra.rotate(nums);
    }
}
