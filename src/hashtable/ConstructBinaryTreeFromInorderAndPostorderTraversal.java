package hashtable;

import binarytree.TreeNode;

/*
https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=problem-list-v2&envId=hash-table
从中序与后序遍历序列构造二叉树

给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。

 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        // 后序遍历的最后一个元素是根节点
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中找到根节点的位置
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // 计算左子树和右子树的大小
        int leftSize = rootIndex - inStart;

        // 构建左子树和右子树
        root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, postorder, rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);

        return root;
    }

    private int[] inorder(TreeNode node) {

        if (node == null) {
            return new int[0];
        }
        int[] left = inorder(node.left);
        int[] right = inorder(node.right);
        int[] result = new int[left.length + right.length + 1];
        System.arraycopy(left, 0, result, 0, left.length);
        result[left.length] = node.val;
        System.arraycopy(right, 0, result, left.length + 1, right.length);
        return result;
    }

    private int[] postorder(TreeNode node) {
        if (node == null) {
            return new int[0];
        }
        int[] left = postorder(node.left);
        int[] right = postorder(node.right);
        int[] result = new int[left.length + right.length + 1];
        System.arraycopy(left, 0, result, 0, left.length);
        System.arraycopy(right, 0, result, left.length, right.length);
        result[left.length + right.length] = node.val;
        return result;
    }
}
