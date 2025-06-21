use crate::binary_tree::tree_node::TreeNode;
use std::cell::RefCell;
use std::collections::LinkedList;
use std::rc::Rc;
struct Solution;
impl Solution {
    pub fn binary_tree_paths(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<String> {
        let mut result: Vec<String> = vec![];
        let mut node_list = LinkedList::new();
        let mut path_list = LinkedList::new();
        if let Some(node) = root {
            node_list.push_back(node.clone());
            let val_str = node.clone().borrow().val.to_string();
            path_list.push_front(val_str);
        }
        while let Some(node) = node_list.pop_front() {
            let node_ref = node.borrow();
            let path = path_list.pop_front().unwrap();
            if node_ref.left == None && node_ref.right == None {
                result.push(path.clone());
            }
            if let Some(left) = &node_ref.left {
                node_list.push_back(left.clone());
                let path = format!("{}->{}", path.clone(), left.borrow().val);
                path_list.push_back(path);
            }

            if let Some(right) = &node_ref.right {
                node_list.push_back(right.clone());
                let path = format!("{}->{}", path.clone(), right.borrow().val);
                path_list.push_back(path);
            }
        }
        return result;
    }
}
#[cfg(test)]
mod tests {
    use crate::binary_tree::binary_tree_paths::{Solution, TreeNode};
    use std::cell::RefCell;
    use std::rc::Rc;

    #[test]
    fn test_binary_tree_paths() {
        let root = Some(Rc::new(RefCell::new(TreeNode {
            val: 1,
            left: None,
            right: None,
        })));
        let vec = Solution::binary_tree_paths(root);
        assert_eq!(vec, vec!["1"]);
    }
}
