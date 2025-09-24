package stringMatching;

/**
 * 另一棵树的子树
 * https://leetcode.cn/problems/subtree-of-another-tree/description/?envType=problem-list-v2&envId=string-matching
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        String serializeRoot = serialize(root);
        String serializeSubRoot = serialize(subRoot);
        return serializeRoot.contains(serializeSubRoot);
    }

    private static String serialize(TreeNode root) {
        if (root == null) {
            return "#";  // 用 "#" 表示空节点
        }

        // 前序遍历: 当前节点值 + 左子树 + 右子树
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }
        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
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
