package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/description/?envType=problem-list-v2&envId=binary-tree
彩灯装饰记录 I

一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照从 左 到 右 的顺序返回每一层彩灯编号。

 */
public class CongShangDaoXiaDaYinErChaShuLcof {

    public int[] decorateRecord(TreeNode root) {


        LinkedList<TreeNode> nodes = new LinkedList<>();
        if (root != null) {
            nodes.addLast(root);
        }

        List<Integer> r = new ArrayList<>();

        while (!nodes.isEmpty()) {
            TreeNode treeNode = nodes.pollFirst();
            r.add(treeNode.val);
            if (treeNode.left != null) {
                nodes.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                nodes.addLast(treeNode.right);
            }
        }
        return r.stream().mapToInt(Integer::intValue).toArray();

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
