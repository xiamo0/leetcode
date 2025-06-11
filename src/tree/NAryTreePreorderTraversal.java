package tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/n-ary-tree-preorder-traversal/description/?envType=problem-list-v2&envId=tree
N 叉树的前序遍历
给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。

n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）
 */
public class NAryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Node child : root.children) {
            list.addAll(preorder(child));
        }
        return list;

    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

}
