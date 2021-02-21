package tree;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    public boolean isValidBST(TreeNode root) {
        return isVaild(root, null, null); // &&isVaildRight(root.right, root.val);
    }

    private boolean isVaild(TreeNode rootNode, Integer lower, Integer upper){
        if (rootNode == null) {
            return true;
        }

        int val = rootNode.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!isVaild(rootNode.right, val, upper)) {
            return false;
        }
        if (!isVaild(rootNode.left, lower, val)) {
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(0);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(6);
        TreeNode h = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.right=e;
        b.left = d;
        c.left = f;
        c.right = g;
        g.left = h;
        IsValidBST is = new IsValidBST();
        System.out.println(is.isValidBST(a));
    }
}
