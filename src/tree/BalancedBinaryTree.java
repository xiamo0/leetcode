package tree;

/*
给定一个二叉树，判断它是否是 平衡二叉树
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 3;
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        isBalanced(treeNode);


    }

    public static boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }
        int leftHeigt = nodeMaxHeight(root.left);
        int rightHeigt = nodeMaxHeight(root.right);
        if (Math.abs(leftHeigt - rightHeigt) > 1) {
            return false;
        }
        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);
        if (!leftBalanced || !rightBalanced) {
            return false;
        }
        return true;

    }

    static int nodeMaxHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = nodeMaxHeight(node.left);
        int rightHeight = nodeMaxHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
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
