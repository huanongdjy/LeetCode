package tree;

/**
 *
 给定一个二叉树，检查它是否是镜像对称的。



 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class IsSymmetric {
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return this.isSameTree(root.left,root.right);
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
