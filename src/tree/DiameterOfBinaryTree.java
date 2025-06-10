package tree;

/*
https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=problem-list-v2&envId=tree
二叉树的直径

给你一棵二叉树的根节点，返回该树的 直径 。

二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。

两节点之间路径的 长度 由它们之间边数表示。
示例 1：
输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。

示例 2：
输入：root = [1,2]
输出：1

提示：

树中节点数目在范围 [1, 104] 内
-100 <= Node.val <= 100


 */
public class DiameterOfBinaryTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }
    static int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
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
