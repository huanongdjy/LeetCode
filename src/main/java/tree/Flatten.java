package tree;

import java.util.LinkedList;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 */
public class Flatten {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr!=null){
            TreeNode next = curr.left;
            if(next!=null){
                TreeNode processNode = next;
                while (processNode.right!=null){
                    processNode = processNode.right;
                }
                processNode.right = curr.right;
                curr.left = null;
                curr.right = next;
            }

            curr = curr.right;
        }
    }
}
