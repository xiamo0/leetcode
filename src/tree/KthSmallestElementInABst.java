package tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=problem-list-v2&envId=tree
二叉搜索树中第 K 小的元素
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。

二叉搜索树是啥
对于每一个节点 node，满足：
	1.	左子树中所有节点的值 < node 的值
	2.	右子树中所有节点的值 > node 的值
	3.	每个子树也是一棵二叉搜索树

 */
public class KthSmallestElementInABst {
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> result = new ArrayList<>();
        loop(root, result);
        return result.get(k - 1);
    }

    static void loop(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        loop(node.left, result);
        result.add(node.val);
        loop(node.right, result);
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
