package tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    public static class TreeNode {
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

    private static List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = 0;
        level(root, level);
        return list;
    }
    private void level(TreeNode node, int level){
        if(node==null)return ;
        List<Integer> temp = new ArrayList();
        temp.add(node.val);
        if(list.size()>level){
            list.get(level).addAll(temp);
        }else {
            list.add(temp);
        }
        this.level(node.left, level+1);
        this.level(node.right, level+1);
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
        LevelOrder levelOrder = new LevelOrder();
        levelOrder.levelOrder(a);
        list.stream().forEach(item ->
                System.out.println(item.toString())
        );
    }
}
