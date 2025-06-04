package tree;

/*
https://leetcode.cn/problems/symmetric-tree/description/?envType=problem-list-v2&envId=tree
给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root, root);
    }

    static boolean isEqual(TreeNode part1, TreeNode part2) {

        if (part1 == null && part2 != null) {
            return false;
        }
        if (part1 != null && part2 == null) {
            return false;
        }
        if (part1 == null && part2 == null) {
            return true;
        }
        boolean valueFlag = part1.val == part2.val;
        if (!valueFlag) {
            return false;
        }
        boolean equal = isEqual(part1.left, part2.right);
        boolean equal1 = isEqual(part1.right, part2.left);
        if (!equal || !equal1) {
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
