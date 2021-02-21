package Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums){
        int l = nums.length;
        if(l < 2) return 1;
        int index = 1,appear=1;
        for(int i = 1; i < l; i++){
            if(nums[i]==nums[i-1]){
                appear++;
            }else {
                appear=1;
            }
            if(appear<=2){
                nums[index++]=nums[i];
            }
        }

       return index;
    }
    public static void main(String[] args) {
//        RemoveDuplicates re  = new RemoveDuplicates( );
//        int[] a = new int[]{0,1,2, 2,2,2 , 2, 2,3,3,4};
////        a[0] = 1;
////        a[1] = 1;
////        a[2] = 2;
//        System.out.println(re.removeDuplicates(a));

        Vector<Integer> list = new Vector<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            Integer i = it.next();
            if (i==3){
                System.out.print(i);
                it.remove();
            }
        }

    }
}
