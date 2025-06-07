package tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/binary-tree-postorder-traversal/description/?envType=problem-list-v2&envId=tree
二叉树的后序遍历
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        loop(root, result);
        return result;
    }

    static void loop(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        loop(node.left, result);
        loop(node.right, result);
        result.add(node.val);
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
