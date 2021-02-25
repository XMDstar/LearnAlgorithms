package simple;

import java.util.Stack;

/**
 * @author zcc
 * @ClassName: JZ62
 * @Date: 2021/2/25 11:34 上午
 * @Description: 搜索二叉树的第K个结点
 * <p>
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 * 示例1
 * 输入
 * {5,3,7,2,4,6,8},3
 * 返回值
 * {4}
 * 说明
 * 按结点数值大小顺序第三小结点的值为4
 * 5
 * 3        7
 * 2   4    6    8
 */
public class JZ62 {
    public static void main(String[] args) {
        TreeNode ll = new TreeNode(2);
        TreeNode lr = new TreeNode(4);
        TreeNode rootL = new TreeNode(3);
        rootL.left = ll;
        rootL.right = lr;
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(8);
        TreeNode rootR = new TreeNode(7);
        rootR.left = rl;
        rootR.right = rr;
        TreeNode root = new TreeNode(5);
        root.left = rootL;
        root.right = rootR;
        int position = 3;
        TreeNode node = KthNode1(root, position);
        System.out.println("第" + position + "小结点的值为:" + (node == null ? "null" : node.val));
    }

    /**
     * 递归中序遍历
     *
     * @param pRoot
     * @param k
     * @return
     */
    private static int i = 0;
    private static TreeNode temp = null;

    private static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;
        loop(pRoot, k);
        return temp;
    }

    private static void loop(TreeNode root, int k) {
        if (root == null || i >= k) return;
        loop(root.left, k);
        if (++i == k) {
            temp = root;
            return;
        }
        loop(root.right, k);
    }

    /**
     * 非递归中序遍历
     * 逻辑类似递归使用栈的特性进行处理
     *
     * @param pRoot
     * @param k
     * @return
     */
    private static TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>(); //建立栈
        TreeNode cur = pRoot;
        //while 部分为中序遍历
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (--k == 0) {
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
