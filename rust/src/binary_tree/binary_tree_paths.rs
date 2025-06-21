use std::cell::RefCell;
use std::collections::VecDeque;
use std::rc::Rc;
use std::borrow::Borrow;
#[derive(Debug, PartialEq, Eq)]
struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}
struct Solution;
impl Solution {
    pub fn binary_tree_paths(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<String> {
        let mut r = Vec::new();
        let mut node_queue = VecDeque::new();
        let mut path_queue = VecDeque::new();
        if let Some(node) = root {
            node_queue.push_back(node.clone());
            let i = RefCell::borrow(&node).val;
            path_queue.push_back(i.to_string());
        }
        while let Some(node) = node_queue.pop_front() {
            let head = RefCell::borrow(&node);
            let head_path = path_queue.pop_front().unwrap();
            if head.left.is_none() && head.right.is_none() {
                r.push(head_path);
            }
            if let Some(left) = head.left.clone() {
                node_queue.push_back(left.clone());
                let path = format!("{}->{}", head_path., left.borrow().val);
                path_queue.push_back(path);
            }
            if let Some(right) = head.right.clone() {
                node_queue.push_back(right.clone());
                let path = format!("{}->{}", head_path, right.borrow().val);
                path_queue.push_back(path);
            }
        }

        return r;
    }
}
#[cfg(test)]
mod tests {
    use std::cell::RefCell;
    use std::rc::Rc;
    use crate::binary_tree::binary_tree_paths::{Solution, TreeNode};

    #[test]
    fn test_binary_tree_paths() {
        let root = Some(Rc::new(RefCell::new(TreeNode { val: 1, left: None, right: None })));
        let vec = Solution::binary_tree_paths(root);
        assert_eq!(vec, vec!["1"]);
    }
}