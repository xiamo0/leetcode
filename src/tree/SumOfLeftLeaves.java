package tree;

/*
https://leetcode.cn/problems/sum-of-left-leaves/description/?envType=problem-list-v2&envId=tree
左叶子之和
给定二叉树的根节点 root ，返回所有左叶子之和。

示例 1：
输入: root = [3,9,20,null,null,15,7]
输出: 24
解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
示例 2:

输入: root = [1]
输出: 0


提示:

节点数在 [1, 1000] 范围内
-1000 <= Node.val <= 1000
 */
public class SumOfLeftLeaves {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null
                && root.left.right == null) {
            sum += root.left.val; // 如果左子节点是叶子节点，累加其值
        }
        sum += sumOfLeftLeaves(root.left); // 递归处理左子树
        sum += sumOfLeftLeaves(root.right); // 递归处理右子树
        return sum;

    }
}
