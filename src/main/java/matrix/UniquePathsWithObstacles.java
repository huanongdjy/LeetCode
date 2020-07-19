package matrix;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        boolean flag = false;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1)return 0;
        if(m==n&&n-1==0&&obstacleGrid[0][0]==0)return 1;
        if(obstacleGrid[m - 1][n - 1] != 0) return 0;
        for (int i = 0; i < n; i++) {
            if(flag){
                obstacleGrid[0][i]=0;
            }else if(obstacleGrid[0][i]!=0){
                obstacleGrid[0][i]=0;
                flag = true;
                continue;
            }else
                obstacleGrid[0][i] = 1;
        }
        flag = false;
        for (int i = 1; i < m; i++) {
            if(flag){
                obstacleGrid[i][0]=0;
            }else if(obstacleGrid[i][0]!=0){
                obstacleGrid[i][0]=0;
                flag = true;
                continue;
            }else
                obstacleGrid[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]!=0){
                    obstacleGrid[i][j]=0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles upwo = new UniquePathsWithObstacles();
        int[][] nums = new int[][]{
                {0,1,0},
                {1,0,0},
                {0,0,0}
        };
//        int[][] nums = new int[][]{
//                {0, 0 },
//                {0, 1 },
//                {1, 1 },
//                {1, 0 },
//                {0, 0}
//        };
//        int[][] nums = new int[][]{
//                {0},
//                {0},
//                {0},
//                {0},
//                {1},
//                {0},
//                {1},
//        };
        System.out.println(upwo.uniquePathsWithObstacles(nums));
    }
}
