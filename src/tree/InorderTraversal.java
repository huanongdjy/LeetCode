package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ÖÐÐò±éÀú
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        InorderTraversal it = new InorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode rigth = new TreeNode(3);
        root.right = left;
        left.left = rigth;
        it.inorderTraversal(root);
    }
}
