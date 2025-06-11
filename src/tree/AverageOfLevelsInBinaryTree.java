package tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/?envType=problem-list-v2&envId=tree
二叉树的层平均值
给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[3.00000,14.50000,11.00000]
解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
因此返回 [3, 14.5, 11] 。

 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<TreeNode> firstRow = new ArrayList<>();
        firstRow.add(root);
        list.add((double) root.val);
        while (!firstRow.isEmpty()) {
            firstRow = getCurRow(firstRow);
            if (firstRow.isEmpty()) {
                break;
            }
            firstRow.stream().mapToDouble(node -> {
                return node.val;
            }).average().ifPresent(list::add);
        }
        return list;
    }

    static List<TreeNode> getCurRow(List<TreeNode> list) {
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        List<TreeNode> nextRow = new ArrayList<>();
        for (TreeNode treeNode : list) {
            if (treeNode.left != null) {
                nextRow.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextRow.add(treeNode.right);
            }
        }
        return nextRow;
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
