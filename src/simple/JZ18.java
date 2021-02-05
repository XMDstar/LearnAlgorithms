package simple;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zcc
 * @ClassName: JZ18
 * @Date: 2021/2/2 11:38 上午
 * @Description: 二叉树的镜像
 *
 * 注意理解递归
 *
 * <p>
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * <p>
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 * 8 6 5 7 10 9 11
 * <p>
 * 中序遍历：左子树---> 根结点 ---> 右子树
 * 5 6 7 8 9 10 11
 * <p>
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 * 5 7 6 9 11 10 8
 * <p>
 * 层次遍历：只需按层次遍历即可
 * 8 6 10 5 7 9 11
 * <p>
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */
public class JZ18 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode root6 = new TreeNode(6);
        TreeNode root10 = new TreeNode(10);
        TreeNode root5 = new TreeNode(5);
        TreeNode root7 = new TreeNode(7);
        TreeNode root9 = new TreeNode(9);
        TreeNode root11 = new TreeNode(11);
        root6.left = root5;
        root6.right = root7;
        root.left = root6;
        root10.left = root9;
        root10.right = root11;
        root.right = root10;
        Mirror(root);
    }

    /**
     * 前序遍历
     * System.out.println(root.val);
     * Mirror(root.left);
     * Mirror(root.right);
     * <p>
     * 后序遍历
     * Mirror(root.left);
     * Mirror(root.right);
     * System.out.println(root.val);
     * <p>
     * 中序遍历
     * Mirror(root.left);
     * System.out.println(root.val);
     * Mirror(root.right);
     *
     * @param root
     */
    public static void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        //层序遍历
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode nodeRoot = nodes.poll();
            System.out.print(nodeRoot.val);
            TreeNode tmp = nodeRoot.left;
            nodeRoot.left = nodeRoot.right;
            nodeRoot.right = tmp;
            if (nodeRoot.left != null) nodes.add(nodeRoot.left);
            if (nodeRoot.right != null) nodes.add(nodeRoot.right);
        }
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}