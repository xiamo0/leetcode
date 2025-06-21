package binarytree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/?envType=problem-list-v2&envId=binary-tree
二叉搜索树的最小绝对差

给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

差值是一个正数，其数值等于两值之差的绝对值。

二叉搜索树特点
1 左小右大
2 中序遍历有序：对二叉搜索树进行中序遍历（左-根-右），得到的结果是一个从小到大的升序序列。
3 不允许重复

 */
public class MinimumAbsoluteDifferenceInBst {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < result.size(); i++) {
            int diff = Math.abs(result.get(i) - result.get(i - 1));
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) return;
        traverse(node.left, result);     // 访问左子树
        result.add(node.val);           // 访问根节点
        traverse(node.right, result);    // 访问右子树
    }

}
