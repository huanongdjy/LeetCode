package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */

public class PathSum {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        help(root, sum, list);
        return ret;
    }
    private void help(TreeNode node, int sum, List list){
        if(node == null){
            return;
        }
        list.add(node.val);
        if(node.left==null&&node.right==null&&sum-node.val==0){
            ret.add(new ArrayList<>(list));
            int index = list.indexOf(node.val);
            if(index!=-1){
                list.remove(index);
            }
            return;
        }
        if(node.right!=null) {
            help(node.right, sum - node.val, list);
        }
        if(node.left!=null) {
            help(node.left, sum - node.val, list);
        }
        int index = list.indexOf(node.val);
        if(index!=-1){
            list.remove(index);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(7);
        TreeNode h = new TreeNode(13);
        TreeNode i = new TreeNode(4);
        TreeNode j = new TreeNode(5);
        TreeNode k = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        d.right = e;
        d.left = f;
        c.left = h;
        c.right = i;
        i.left = j;
        i.right = k;
        PathSum ps = new PathSum();
        List ret = ps.pathSum(a, 22);
        System.out.println(ret.toString());

    }
}
