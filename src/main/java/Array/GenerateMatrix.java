package Array;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n){
        int[][] ret = new int[n][n];
        int num = 1;
        for(int i=0;i < (n + 1)/2; i++){
            for(int j=i;j < n - i; j++, num++){
                ret[i][j]=num;
            }
            for(int j= i + 1; j< n -i ; j++, num++){
                ret[j][n-i-1] = num;
            }
            for(int j=n-i-2; j>=i&&(n-1-i)!=i; j--, num++){
                ret[n-i -1][j] = num;
            }
            for(int j=n-i-2; j>i&&i!=n-i-1; j--, num++){
                ret[j][i] = num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        GenerateMatrix gm = new GenerateMatrix();
        int[][] ret = gm.generateMatrix(3);
        for(int i=0; i<ret.length; i++){
            for(int j=0; j<ret.length;j++){
                System.out.println(ret[i][j]);
            }
        }
    }
}
