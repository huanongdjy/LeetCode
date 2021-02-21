package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class LevelOrderBottom {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrder(root, 0);
        Collections.reverse(result);
        return result;
    }
    private void levelOrder(TreeNode node , int deepth){
        if(node==null)return;
        if(result.size()>deepth){
            result.get(deepth).add(node.val);
        }else {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            result.add(temp);
        }
        levelOrder(node.left, deepth+1);
        levelOrder(node.right, deepth+1);
    }
}
