package binarysearch;

/*
https://leetcode.cn/problems/count-complete-tree-nodes/description/?envType=problem-list-v2&envId=binary-search

给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层（从第 0 层开始），
则该层包含 1~ 2h 个节点。

输入：root = [1,2,3,4,5,6]
输出：6

 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root != null) {
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            count = 1 + leftCount + rightCount;
        }
        return count;
    }

    class TreeNode {
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

