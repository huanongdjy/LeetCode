package tree;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null&& root.right==null)return 1;
        int depth = Integer.MAX_VALUE;
        if(root.left!=null){
            depth = Math.min(minDepth(root.left), depth);
        }
        if(root.right!=null){
            depth = Math.min(minDepth(root.right), depth);
        }
        return depth+1;
    }

}
