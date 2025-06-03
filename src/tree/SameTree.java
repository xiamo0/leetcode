package tree;

/*
https://leetcode.cn/problems/same-tree/description/?envType=problem-list-v2&envId=tree
给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。


 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q != null) {
            return false;
        }
        boolean valFlag = p.val == q.val;
        boolean leftFlag = isSameTree(p.left, q.left);
        boolean rightFlag = isSameTree(p.right, q.right);
        if (!leftFlag || !valFlag || !rightFlag) {
            return false;
        }
        return true;
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
