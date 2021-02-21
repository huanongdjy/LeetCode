package tree;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    private TreeNode helper(int[] nums, int left, int right){
        if(left>right)return null;
        int mid = (right + left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        TreeNode leftNode = helper(nums, left, mid - 1);
        TreeNode rightNode = helper(nums, mid + 1, right);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}
