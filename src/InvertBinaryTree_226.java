import java.util.Objects;

/**
 * https://leetcode.cn/problems/invert-binary-tree/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class InvertBinaryTree_226 {

    public static void main(String[] args) {

    }

    static TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;

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
