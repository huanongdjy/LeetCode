package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class BuildTreeII extends  Thread{
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = inorder.length-1;
        for (int i = postorder.length-2; i >= 0 ; i--) {
            int preorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(preorderVal);
            //一定会是左字节点，先序遍历找到与中序遍历的数组中相同的值后，判断是哪个子节点的右子节点
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }


    private synchronized void p() throws InterruptedException {
        System.out.println("1");
        Thread.sleep(5000);
        System.out.println("3");
    }

    @Override
    public void run() {
        try {
            p();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized  void b()  {
        System.out.println("2");
    }
    public static void main(String[] args) throws InterruptedException {
//        int[] a = {9,3,15,20,7};
//        int[] b = {9,15,7,20,3};
//        BuildTreeII buildTreeII = new BuildTreeII();
//        buildTreeII.buildTree(a, b);
        BuildTreeII t2 = new BuildTreeII();
        t2.start();
        Thread.sleep(1000);
        BuildTreeII t3 = new BuildTreeII();
        t3.b();

//        int a=16;
//        System.out.println(16 >>> 1);

    }
//    [9,3,15,20,7]
//    [9,15,7,20,3]
}
