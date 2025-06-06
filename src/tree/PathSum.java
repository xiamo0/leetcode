package tree;

/*
https://leetcode.cn/problems/path-sum/description/?envType=problem-list-v2&envId=tree
路径总和
给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。

输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
输出：true
解释：等于目标和的根节点到叶节点路径如上图所示。
 */
public class PathSum {

    static boolean isExists(TreeNode node, int targetSum) {
        int remain = targetSum - node.val;
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left == null && right == null) {
            return remain == 0;
        }

        boolean leftFlag = false;
        boolean rightFlag = false;
        if (left != null) {
            leftFlag = isExists(left, remain);
        }
        if (right != null) {
            rightFlag = isExists(right, remain);
        }
        return leftFlag || rightFlag;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return isExists(root, targetSum);
    }


    static class TreeNode {
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

}
