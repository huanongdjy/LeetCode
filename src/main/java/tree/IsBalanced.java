package tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {

        return helper(root, 0)!=-1;
    }
    private int helper(TreeNode node, int depth){
        if(node == null)return depth;
        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth+1);
        if(left==-1||right==-1)return -1;
        int dif = left - right;
        if(Math.abs(dif)>1){
            return -1;
        }
        return Math.max(left, right);
    }
}
