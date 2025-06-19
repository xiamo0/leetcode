package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
https://leetcode.cn/problems/binary-tree-paths/description/?envType=problem-list-v2&envId=binary-tree
二叉树的所有路径
给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

叶子节点 是指没有子节点的节点。
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> dfs = dfs(root);
        return dfs.stream().map(item -> {
            return item.stream().map(String::valueOf).collect(Collectors.joining("->"));
        }).collect(Collectors.toList());

    }

    List<List<Integer>> bfs(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode>linkedList=new LinkedList<>();
        linkedList.addLast(node);
        while (!linkedList.isEmpty()){
            TreeNode treeNode = linkedList.removeFirst();
            int val = treeNode.val;
            


        }
    }

    List<List<Integer>> dfs(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        List<List<Integer>> left = dfs(node.left);
        if (!left.isEmpty()) {
            for (List<Integer> list : left) {
                List<Integer> temp = new ArrayList<>();
                temp.add(node.val);
                temp.addAll(list);
                result.add(temp);
            }
        }
        List<List<Integer>> right = dfs(node.right);
        if (!right.isEmpty()) {
            for (List<Integer> list : right) {
                List<Integer> temp = new ArrayList<>();
                temp.add(node.val);
                temp.addAll(list);
                result.add(temp);
            }
        }
        if (result.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            result.add(temp);
        }
        return result;

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
