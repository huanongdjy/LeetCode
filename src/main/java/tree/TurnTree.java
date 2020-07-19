package tree;

import java.util.ArrayList;
import java.util.List;

public class TurnTree {
    List<Integer> flipped;
    int index;
    int[] voyage;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        flipped = new ArrayList();
        index = 0;
        this.voyage = voyage;

        dfs(root);
        if (!flipped.isEmpty() && flipped.get(0) == -1) {
            flipped.clear();
            flipped.add(-1);
        }

        return flipped;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            if (node.val != voyage[index++]) {
                flipped.clear();
                flipped.add(-1);
                return;
            }

            if (index < voyage.length && node.left != null &&
                    node.left.val != voyage[index]) {
                flipped.add(node.val);
                dfs(node.right);
                dfs(node.left);
            } else {
                dfs(node.left);
                dfs(node.right);
            }
        }
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

    public static void main(String[] args) {
        TurnTree tr = new TurnTree();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode rigth = new TreeNode(3);
        root.left = left;
        root.right = rigth;
        int[] v = {1,3,2};
        tr.flipMatchVoyage(root, v);
     }
}
