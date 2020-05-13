package Array;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Trap {
    public int trap(int[] height) {
        if(height.length <=0 )return 0;
        int result = 0;
        int left = 0;
        int right = height.length -1;
        int r_height = height[right], l_height = height[0];
        while (left<right){
            if(height[right] <= height[left]){
                if(r_height > height[right - 1])
                    result += r_height - height[right - 1];
                right--;
                if(r_height <= height[right ])
                    r_height=height[right ];
                continue;
            }
            if(height[right] >= height[left]){
                if(l_height > height[left+1])
                    result += l_height - height[left+1];
                left++;
                if(l_height <= height[left])
                    l_height = height[left];
                continue;
            }
        }
        return result;
    }
}
