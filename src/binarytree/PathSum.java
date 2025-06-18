package binarytree;

import java.util.LinkedList;

/*
https://leetcode.cn/problems/path-sum/description/?envType=problem-list-v2&envId=binary-tree
路径总和
给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。
 */
public class PathSum {

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int remain = targetSum - root.val;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        if (remain == 0 && leftNode == null && rightNode == null) {
            return true;
        }
        boolean leftFlag = false;
        if (leftNode != null) {
            leftFlag = hasPathSum(leftNode, remain);
        }
        boolean rightFlag = false;
        if (rightNode != null) {
            rightFlag = hasPathSum(rightNode, remain);
        }
        return rightFlag || leftFlag;

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> nodeLinkedList = new LinkedList<>();
        LinkedList<Integer> valLinkedList = new LinkedList<>();
        nodeLinkedList.addFirst(root);
        valLinkedList.addFirst(root.val);
        //bfs
        while (!nodeLinkedList.isEmpty()) {
            TreeNode node = nodeLinkedList.removeFirst();
            TreeNode leftNode = node.left;
            TreeNode rightNode = node.right;

            Integer i = valLinkedList.removeFirst();
            if (i == targetSum && leftNode == null && rightNode == null) {
                return true;
            }
            if (leftNode != null) {
                nodeLinkedList.addLast(leftNode);
                valLinkedList.addLast(leftNode.val+i);
            }
            if (rightNode != null) {
                nodeLinkedList.addLast(rightNode);
                valLinkedList.addLast(rightNode.val+i);
            }

        }
        return false;
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
