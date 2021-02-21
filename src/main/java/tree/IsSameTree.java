package tree;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 */
public class IsSameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null&&q==null)return false;
        if(p==null&&q!=null)return false;
        if(p==null&&q==null)return true;
        if(p.val!=q.val)return false;
        if(!isSameTree(p.left, q.left))return false;
        if(!isSameTree(p.right, q.right))return false;
        return true;
    }
}
