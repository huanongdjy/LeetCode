package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while(head!=null){
            nums.add(head.val);
            head = head.next;
        }
        return helper(nums, 0, nums.size()-1);
    }
    private TreeNode helper(List<Integer> nums, int left, int right){
        if(left>right)return null;
        int mid = (right + left)/2;
        TreeNode node = new TreeNode(nums.get(mid));
        TreeNode leftNode = helper(nums, left, mid - 1);
        TreeNode rightNode = helper(nums, mid + 1, right);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}
