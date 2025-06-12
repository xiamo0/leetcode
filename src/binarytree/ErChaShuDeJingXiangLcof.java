package binarytree;

/*
https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/?envType=problem-list-v2&envId=binary-tree
翻转二叉树
给定一棵二叉树的根节点 root，请左右翻转这棵二叉树，并返回其根节点。


 */
public class ErChaShuDeJingXiangLcof {
    public TreeNode flipTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode left = flipTree(root.left);
        TreeNode right = flipTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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
