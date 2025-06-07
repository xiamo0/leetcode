package tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/binary-tree-preorder-traversal/description/?envType=problem-list-v2&envId=tree
二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

示例 1：

输入：root = [1,null,2,3]

输出：[1,2,3]


 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        List<Integer> leftList = preorderTraversal(root.left);
        if (leftList != null && !leftList.isEmpty()) {
            result.addAll(leftList);
        }
        List<Integer> rightList = preorderTraversal(root.right);
        if (rightList != null && !rightList.isEmpty()) {
            result.addAll(rightList);
        }
        return result;

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
